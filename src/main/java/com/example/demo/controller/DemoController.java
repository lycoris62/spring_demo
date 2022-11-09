package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.service.DemoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DemoController {

    private DemoService demoService;

    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    @GetMapping("/")
    @ResponseBody
    public String home() {
        return "Hello World!";
    }

    @GetMapping("/api/v1/save")
    @ResponseBody
    public UserDTO save(@RequestParam String name) {
        UserDTO user = new UserDTO();
        user.setName(name);
        return demoService.save(user);
    }

    @GetMapping("/api/v1/user/{id}")
    @ResponseBody
    public UserDTO findById(@PathVariable Long id) {
        return demoService.findById(id);
    }

    @GetMapping("/api/v1/user")
    @ResponseBody
    public List<UserDTO> findAll() {
        return demoService.findAll();
    }
}
