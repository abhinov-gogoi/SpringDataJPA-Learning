package com.example.springdatajpa.task;

import com.example.springdatajpa.employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @RequestMapping("/employee/{empId}/tasks")
    public List<Task> getAllTasks(@PathVariable String empId) {
        return taskService.getAllTasksForAnEmployee(empId);
    }

    @RequestMapping("/employees/{employeeId}/tasks/{id}")
    public Task getTask(@PathVariable String employeeId, @PathVariable String id) {
        return taskService.getTask(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/employees/{employeeId}/tasks")
    public void addTask(@RequestBody Task task, @PathVariable String employeeId) {
        task.setEmployee(new Employee(employeeId, "", ""));
        taskService.addTask(task);
    }

    @RequestMapping(method = RequestMethod.PUT,  value = "/employees/{employeeId}/tasks/{id}")
    public void updateTask(@RequestBody Task task, @PathVariable String id, @PathVariable String employeeId) {
        task.setEmployee(new Employee(employeeId, "", ""));
        taskService.updateTask(task);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/employees/{employeeId}/tasks/{id}")
    public void deleteTask(@PathVariable String id, @PathVariable String employeeId) {
        taskService.deleteTask(id);
    }
}
