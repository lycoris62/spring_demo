package com.example.demo.repository;

import com.example.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class DemoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static Map<Long, User> userList = new HashMap<>();
    private static long sequence = 0L;

    public User save(User user) {
        String query = "insert into user_table(name) values(?)";
        jdbcTemplate.update(query, user.getName());
        String sql = "Select user_id, name from user_table order by user_id DESC limit 1";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            User userDB = new User();
            userDB.setId(rs.getLong("user_id"));
            userDB.setName(rs.getString("name"));
            return userDB;
        }).get(0);
    }

    public User findById(Long id) {
        String sql = "Select user_id, name from user_table where user_id = ?";
        return jdbcTemplate.query(sql, new Object[]{id}, (rs, rowNum) -> {
            User user = new User();
            user.setId(rs.getLong("user_id"));
            user.setName(rs.getString("name"));
            return user;
        }).get(0);
    }

    public List<User> findAll() {
        String sql = "select user_id, name from user_table";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            User user = new User();
            user.setId(rs.getLong("user_id"));
            user.setName(rs.getString("name"));
            return user;
        });
    }
}
