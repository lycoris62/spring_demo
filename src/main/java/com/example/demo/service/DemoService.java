package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.repository.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoService {
    @Autowired
    private DemoRepository demoRepository;

    public User save(User user) {
        return demoRepository.save(user);
    }

    public User findById(Long id) {
        return demoRepository.findById(id);
    }

    public List<User> findAll() {
        return demoRepository.findAll();
    }
}
