package com.taskmanagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.taskmanagement.Entity.SignUp;
import com.taskmanagement.Services.SignUpServices;

@Controller
public class LoginController {

    @Autowired
    private SignUpServices signUpServices;
    @GetMapping("/signup")
    public String signup(@ModelAttribute("signup") SignUp signUp)
    {
        return "signup";
    }
    @PostMapping("/signup")
    public String signupHandler(@ModelAttribute("signup")SignUp signUp)
    {
        this.signUpServices.saveSignup(signUp);
        return "redirect:/homepage";
    }
}