package school21.spring.service.repositories;

import school21.spring.service.models.User;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbcImpl implements UsersRepository {
    private final DataSource dataSource;

    public UsersRepositoryJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public User findById(Long id) {
        User user = null;
        String SQL_SELECT_BY_ID = "SELECT * FROM users WHERE identity=?";
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_BY_ID);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String email = resultSet.getString("email");
                user = new User(id, email);
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        String SQL_SELECT_ALL = "SELECT * FROM users";
        List<User> userList = new ArrayList<>();
        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL);
            while (resultSet.next()) {
                Long identity = resultSet.getLong("identity");
                String email = resultSet.getString("email");
                User user = new User(identity, email);
                userList.add(user);
            }
            return userList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public void save(User entity) {
        String SQL_INSERT = "INSERT INTO users(email) VALUES(?)";
        User user = null;
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT);
            statement.setString(1, entity.getEmail());
            if (statement.executeLargeUpdate() == 0) {
                throw new IllegalAccessException("Not save");
            }
        } catch (SQLException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(User entity) {
        String SQL_UPDATE = "UPDATE users SET identity = ?, email = ?";
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_UPDATE);
            statement.setLong(1, entity.getIdentifier());
            statement.setString(2, entity.getEmail());
            if (statement.executeUpdate() == 0) {
                throw new IllegalAccessException("Not update");
            }
        } catch (SQLException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        String SQL_DELETE = "DELETE FROM users WHERE identity=?";
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_DELETE);
            statement.setLong(1, id);
            if (statement.executeUpdate() == 0) {
                throw new IllegalAccessException("Not delete");
            }
            else {
                System.out.println("DELETED by " + id);
            }
        } catch (SQLException | IllegalAccessException e) {
            try {
                throw new IllegalAccessException(e.getMessage());
            } catch (IllegalAccessException illegalAccessException) {
                illegalAccessException.printStackTrace();
            }
        }
    }

    @Override
    public Optional<User> findByEmail(String email) {
        Optional<User> userOptional = Optional.empty();
        String SQL_SELECT_BY_ID = "SELECT * FROM users WHERE email=?";
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_BY_ID);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next())
            {
                Long id = resultSet.getLong("identity");
                User user = new User(id, email);
                userOptional = Optional.of(user);
            }
            return  userOptional;
        } catch (SQLException e) {
            try {
                throw new IllegalAccessException(e.getMessage());
            } catch (IllegalAccessException illegalAccessException) {
                illegalAccessException.printStackTrace();
            }
        }
        return userOptional;
    }
}
