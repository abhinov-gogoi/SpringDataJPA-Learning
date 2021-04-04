package com.example.springdatajpa.task;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task, String> {

    public List<Task> findByEmployeeId(String empId); // www.youtube.com/watch?v=_Jnu_jHfQbM&list=PLqq-6Pq4lTTbx8p2oCgcAQGQyqN8XeA1x

}
