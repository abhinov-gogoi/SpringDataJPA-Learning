package com.example.springdatajpa;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Homepage {
    @RequestMapping("/")
    public String sayHello() {
        return "Welcome to Spring Data JPA";
    }
}
