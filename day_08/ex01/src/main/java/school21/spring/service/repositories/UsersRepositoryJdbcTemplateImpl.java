package school21.spring.service.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import school21.spring.service.models.User;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbcTemplateImpl implements UsersRepository {

    private final JdbcTemplate jdbcTemplate;

    public UsersRepositoryJdbcTemplateImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private static final RowMapper<User> userRowMapper = (rs, rowNum) -> {
        Long identifier = rs.getLong("identity");
        String email = rs.getString("email");
        return new User(identifier, email);
    };

    @Override
    public User findById(Long id) {
        List<User> newUser;
        String SQL_SELECT_BY_ID = "SELECT * FROM users WHERE identity=?";
        newUser = jdbcTemplate.query(SQL_SELECT_BY_ID, userRowMapper, id);
        if (newUser.isEmpty()) {
            return null;
        } else {
            return newUser.get(0);
        }
    }

    @Override
    public List<User> findAll() {
        List<User> userList;
        String SQL_SELECT_ALL = "SELECT * FROM users";
        userList = jdbcTemplate.query(SQL_SELECT_ALL, userRowMapper);
        return userList;
    }

    @Override
    public void save(User entity) {
        String SQL_INSERT = "INSERT INTO users(email) VALUES(?)";
        jdbcTemplate.update(SQL_INSERT, entity.getEmail());
    }

    @Override
    public void update(User entity) {
        String SQL_UPDATE = "UPDATE users SET identity = ?, email = ?";
        jdbcTemplate.update(SQL_UPDATE, entity.getIdentifier(), entity.getEmail());
    }

    @Override
    public void delete(Long id) {
        String SQL_DELETE = "DELETE FROM users WHERE identity=?";
        this.jdbcTemplate.update(SQL_DELETE, id);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        String SQL_FIND_BY_EMAIL = "SELECT * FROM users WHERE email=?";
        List<User> userList = jdbcTemplate.query(SQL_FIND_BY_EMAIL, userRowMapper, email);
        if (userList.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(userList.get(0));
        }
    }
}
