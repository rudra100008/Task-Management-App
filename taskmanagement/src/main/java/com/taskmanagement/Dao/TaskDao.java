package com.taskmanagement.Dao;

import org.springframework.data.repository.CrudRepository;

import com.taskmanagement.Entity.Task;

public interface TaskDao extends CrudRepository<Task,Integer> {
    
}
