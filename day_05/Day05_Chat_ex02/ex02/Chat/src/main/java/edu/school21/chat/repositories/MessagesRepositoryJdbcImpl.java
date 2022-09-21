package edu.school21.chat.repositories;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository {

    private HikariDataSource dataSource;
    ResultSet resultSet, resultSet1;
    Message message;

    public MessagesRepositoryJdbcImpl(HikariDataSource datasource) {
        this.dataSource = datasource;
    }

    public static final String SQL_SELECT_MESSAGE = "SELECT * , users.userId as id_user, chatrooms.id as id_room\n" +
            "FROM messages\n" +
            "LEFT JOIN users ON messages.author = users.userId\n" +
            "LEFT JOIN chatrooms ON messages.room = chatrooms.id\n" +
            "WHERE messages.id=";

    public static final String SQL_INSERT_MESSAGE = "INSERT INTO messages(text, date, author, room) VALUES(?, ?, ?, ?)";

    public static final String SQL_SELECT_ID = "SELECT id FROM messages ORDER BY id DESC LIMIT 1";

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
            connection.close();
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void save(Message message) {
        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_MESSAGE);
            resultSet1 = statement.executeQuery(SQL_SELECT_ID);
            Long lastId = 0l;
            if (resultSet1.next()) {
                lastId = resultSet1.getLong("id");
            }
            preparedStatement.setString(1, message.getText());
            preparedStatement.setTimestamp(2, Timestamp.valueOf(message.getDate()));
            preparedStatement.setLong(3, message.getAuthor().getUserId());
            preparedStatement.setLong(4, message.getRoom().getId());
            //resultSet1 = preparedStatement1.executeQuery();

            if (preparedStatement.executeUpdate() == 1) {
                resultSet1 = statement.executeQuery(SQL_SELECT_ID);
                if (resultSet1.next()) {
                    Long newLast_id = resultSet1.getLong("id");
                    if (newLast_id != lastId) {
                        message.setId(newLast_id);
                        System.out.println("Message is added");
                        return;
                    }
                }
            } else {
                System.out.println("Message is not added");
            }

        } catch (SQLException | NullPointerException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
