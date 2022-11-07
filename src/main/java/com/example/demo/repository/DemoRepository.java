package com.example.demo.repository;

import com.example.demo.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class DemoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static Map<Long, UserDTO> userList = new HashMap<>();
    private static long sequence = 0L;

    public UserDTO save(UserDTO user) {
        String query = "insert into user_table(name) values(?)";
        jdbcTemplate.update(query, user.getName());
        String sql = "Select user_id, name from user_table order by user_id DESC limit 1";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            UserDTO userDB = new UserDTO();
            userDB.setId(rs.getLong("user_id"));
            userDB.setName(rs.getString("name"));
            return userDB;
        }).get(0);
    }

    public UserDTO findById(Long id) {
        String sql = "Select user_id, name from user_table where user_id = ?";
        return jdbcTemplate.query(sql, new Object[]{id}, (rs, rowNum) -> {
            UserDTO user = new UserDTO();
            user.setId(rs.getLong("user_id"));
            user.setName(rs.getString("name"));
            return user;
        }).get(0);
    }

    public List<UserDTO> findAll() {
        String sql = "select user_id, name from user_table";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            UserDTO user = new UserDTO();
            user.setId(rs.getLong("user_id"));
            user.setName(rs.getString("name"));
            return user;
        });
    }
}
