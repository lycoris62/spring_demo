package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DemoController {
    @Autowired
    private DemoService demoService;

    @GetMapping("/")
    @ResponseBody
    public String home() {
        return "Hello World!";
    }

    @GetMapping("/api/v1/save")
    @ResponseBody
    public User save(@RequestParam String name) {
        User user = new User();
        user.setName(name);
        return demoService.save(user);
    }

    @GetMapping("/api/v1/user/{id}")
    @ResponseBody
    public User findById(@PathVariable Long id) {
        return demoService.findById(id);
    }

    @GetMapping("/api/v1/user")
    @ResponseBody
    public List<User> findAll() {
        return demoService.findAll();
    }
}
