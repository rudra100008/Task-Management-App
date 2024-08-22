package com.taskmanagement.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskmanagement.Dao.TaskDao;
import com.taskmanagement.Entity.Task;

@Service
public class TaskServices {
    @Autowired
    private TaskDao taskDao;

    public void addTask(Task task){
        this.taskDao.save(task);
    
    }
    
}
