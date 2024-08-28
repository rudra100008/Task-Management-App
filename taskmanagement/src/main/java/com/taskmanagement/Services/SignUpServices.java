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
    public boolean validateUser(String username,String password)
    {
        SignUp signUp =  this.signUpDao.findByUsername(username);
        if (signUp !=null  && username.equals(signUp.getUsername()) && password.equals(signUp.getPassword()) ) {
            return true;
        }else{
            return false;
        }
    }
        
}
