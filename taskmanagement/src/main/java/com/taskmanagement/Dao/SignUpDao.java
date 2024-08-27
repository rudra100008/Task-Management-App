package com.taskmanagement.Dao;

import org.springframework.data.repository.CrudRepository;

import com.taskmanagement.Entity.SignUp;

public interface SignUpDao extends CrudRepository<SignUp,Integer> {
    
}
