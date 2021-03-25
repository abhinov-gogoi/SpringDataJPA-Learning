package com.example.springdatajpa.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// In spring, business services are usually singleton classes which are used by other classes
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    private List<Employee> employees = new ArrayList<>(Arrays.asList(
            new Employee("1", "John", "Java Developer"),
            new Employee("2", "Mike", "Python Developer"),
            new Employee("3", "Mary", "PHP Developer"),
            new Employee("4", "Jinny", ".NET Developer")
    )) ;

    public List<Employee> getAllTopics() {
        List<Employee> employees = new ArrayList<>();
        employeeRepository.findAll().forEach(employees::add);
        return employees;
    }

    public Employee getTopic(String id) {
        return employees.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }

    public void addTopic(Employee employee) {
        employeeRepository.save(employee);
    }

    public void updateTopic(Employee employee, String id) {
        for (int i = 0; i< employees.size(); i++) {
            Employee t = employees.get(i);
            if(t.getId().equals(id)) {
                employees.set(i, employee);
                return;
            }
        }
    }

    public void deleteTopic(String id) {
        employees.removeIf(employee -> employee.getId().equals(id));
    }
}
