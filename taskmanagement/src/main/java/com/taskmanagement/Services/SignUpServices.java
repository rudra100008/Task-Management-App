package com.taskmanagement.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskmanagement.Dao.SignUpDao;
import com.taskmanagement.Entity.SignUp;

@Service
public class SignUpServices {
    @Autowired
    private SignUpDao signUpDao;
    
    public void saveSignup(SignUp signup)
    {
        this.signUpDao.save(signup);
    }
    
}
