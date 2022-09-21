package edu.school21.chat.repositories;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository {

    private HikariDataSource dataSource;
    ResultSet resultSet;
    Message message;

    public MessagesRepositoryJdbcImpl(HikariDataSource datasource) {
        this.dataSource = datasource;
    }

    public static final String SQL_SELECT_MESSAGE = "SELECT * , users.userId as id_user, chatrooms.id as id_room\n" +
            "FROM messages\n" +
            "LEFT JOIN users ON messages.author = users.userId\n" +
            "LEFT JOIN chatrooms ON messages.room = chatrooms.id\n" +
            "WHERE messages.id=";

    @Override
    public Optional<Message> findById(Long id) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_MESSAGE + id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Long userId = resultSet.getLong("userId");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                User author = new User(userId, login, password);
                Long chatroomId = resultSet.getLong("id");
                String name = resultSet.getString("name");
                Long owner = resultSet.getLong("owner");
                Chatroom chatroom = new Chatroom(chatroomId, name);
                String text = resultSet.getString("text");
                Object object = resultSet.getObject("date");
                LocalDateTime localDateTime;
                if (object == null) {
                    localDateTime = null;
                } else {
                    localDateTime = resultSet.getTimestamp("date").toLocalDateTime();
                }
                return Optional.of(new Message(id, author, chatroom, text, localDateTime));
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
