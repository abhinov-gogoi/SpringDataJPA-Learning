package com.example.springdatajpa.db;

import com.example.springdatajpa.employee.Employee;
import com.example.springdatajpa.employee.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PostgresConfig implements CommandLineRunner {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... args) throws Exception {
        String query = "insert into employee(id, name, description) values('2', 'Abhi', 'Java Developer')";
        int rows = jdbcTemplate.update(query);
        if (rows>1){
            System.out.println("A new row has been inserted");
        }

        List<Employee> employees = employeeRepository.findAll();
        employees.forEach(System.out::println);
    }
}
