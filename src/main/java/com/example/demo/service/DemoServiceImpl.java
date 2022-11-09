package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import com.example.demo.repository.DemoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoServiceImpl implements DemoService {

    private DemoRepository demoRepository;

    public DemoServiceImpl(DemoRepository demoRepository) {
        this.demoRepository = demoRepository;
    }

    @Override
    public UserDTO save(UserDTO user) {
        return demoRepository.save(user);
    }

    @Override
    public UserDTO findById(Long id) {
        return demoRepository.findById(id);
    }

    @Override
    public List<UserDTO> findAll() {
        return demoRepository.findAll();
    }
}
