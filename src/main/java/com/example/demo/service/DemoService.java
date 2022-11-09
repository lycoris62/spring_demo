package com.example.demo.service;

import com.example.demo.dto.UserDTO;

import java.util.List;

public interface DemoService {

    public UserDTO save(UserDTO user);

    public UserDTO findById(Long id);

    public List<UserDTO> findAll();
}
