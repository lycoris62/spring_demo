package com.example.demo.repository;

import com.example.demo.dto.UserDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class JdbcDemoRepository implements DemoRepository {

    private final JdbcTemplate jdbcTemplate;

    public JdbcDemoRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
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

    @Override
    public UserDTO findById(Long id) {
        String sql = "Select user_id, name from user_table where user_id = ?";
        return jdbcTemplate.query(sql, new Object[]{id}, (rs, rowNum) -> {
            UserDTO user = new UserDTO();
            user.setId(rs.getLong("user_id"));
            user.setName(rs.getString("name"));
            return user;
        }).get(0);
    }

    @Override
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
