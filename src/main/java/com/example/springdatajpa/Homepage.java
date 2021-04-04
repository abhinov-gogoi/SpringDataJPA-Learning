package com.example.springdatajpa;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class Homepage {

    @RequestMapping("/")
    public String sayHello() {

        return "Welcome to Spring Data JPA. Your Current date is : "+ calcTime();
    }

    public String calcTime() {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'and time is : 'HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }
}
