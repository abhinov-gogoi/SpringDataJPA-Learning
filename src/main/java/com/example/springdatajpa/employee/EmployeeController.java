package com.example.springdatajpa.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployee();
    }

    @RequestMapping("/employees/{employee-id}")
    public Employee getEmployee(@PathVariable("employee-id") String id) {
        return employeeService.getEmployee(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/employees")
    public void addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/employees/{id}")
    public void updateEmployee(@RequestBody Employee employee, @PathVariable String id) {
        employeeService.updateEmployee(employee, id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/employees/{id}")
    public void deleteEmployee(@PathVariable String id) {
        employeeService.deleteEmployee(id);
    }
}
