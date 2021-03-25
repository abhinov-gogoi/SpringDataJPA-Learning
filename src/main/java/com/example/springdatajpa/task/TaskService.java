package com.example.springdatajpa.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// In spring, business services are usually singleton classes which are used by other classes
@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasksForAnEmployee(String empId) {
        List<Task> tasks = new ArrayList<>();
        taskRepository.findByEmployeeId(empId).forEach(tasks::add);
        return tasks;
    }

    public Task getTask(String id) {
        return taskRepository.findById(id).orElse(null);
    }

    public void addTask(Task task) {
        taskRepository.save(task);
    }

    public void updateTask(Task task) {
        taskRepository.save(task);
    }

    public void deleteTask(String id) {
        taskRepository.deleteById(id);
    }
}
