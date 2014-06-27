package com.authentication.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Nonnull;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.authentication.beans.Authenticate;
import com.authentication.beans.User;

public class UserDaoImpl implements UserDao {

    @Nonnull
    private JdbcTemplate jdbcTemplate;

    public @Nonnull
    User authenticateUser(@Nonnull Authenticate authenticate) {
        String query = "select * from user where email=? and password=MD5(?)";
        User user = new User();

        try {
            String username = authenticate.getUsername();
            String password = authenticate.getPassword();
            user = (User)jdbcTemplate.queryForObject(query, new Object[] {username, password}, new RowMapper<User>() {

                @Override
                public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                    User user =
                            new User(rs.getInt("id"), rs.getString("api_key"), rs.getBoolean("is_active"), rs
                                    .getString("email"), rs.getString("first_name"), rs.getString("last_name"), rs
                                    .getString("date_joine"), rs.getString("last_login"), rs.getBoolean("is_superus"));
                    return user;
                }
            });
        } catch (org.springframework.dao.EmptyResultDataAccessException e) {
            user = new User();
            user.setId(-1);
        } catch (Exception e) {
            user = new User();
            user.setId(-2);
        }
        return user;
    }

    public int insertApiKey(@Nonnull Authenticate authenticate, @Nonnull String api_key) {
        String query = "update user set api_key=?,last_login=now() where email=?";
        String email = authenticate.getUsername();
        int rowCount = jdbcTemplate.update(query, api_key, email);
        return rowCount;
    }

    public void setJdbcTemplate(@Nonnull JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
