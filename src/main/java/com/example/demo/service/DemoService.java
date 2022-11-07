package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import com.example.demo.repository.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoService {
    @Autowired
    private DemoRepository demoRepository;

    public UserDTO save(UserDTO user) {
        return demoRepository.save(user);
    }

    public UserDTO findById(Long id) {
        return demoRepository.findById(id);
    }

    public List<UserDTO> findAll() {
        return demoRepository.findAll();
    }
}
