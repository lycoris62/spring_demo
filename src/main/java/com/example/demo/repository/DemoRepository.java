package com.example.demo.repository;

import com.example.demo.dto.UserDTO;

import java.util.List;

public interface DemoRepository {
    public UserDTO save(UserDTO user);

    public UserDTO findById(Long id);

    public List<UserDTO> findAll();
}
