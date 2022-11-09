package com.example.demo;

import com.example.demo.repository.DemoRepository;
import com.example.demo.repository.JdbcDemoRepository;
import com.example.demo.service.DemoService;
import com.example.demo.service.DemoServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class AppConfig {

    private DataSource dataSource;

    public AppConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public DemoService demoService() {
        return new DemoServiceImpl(demoRepository());
    }

    @Bean
    public DemoRepository demoRepository() {
        return new JdbcDemoRepository(dataSource);
    }
}
