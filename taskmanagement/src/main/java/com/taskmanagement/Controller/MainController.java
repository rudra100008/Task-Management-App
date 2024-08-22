package com.taskmanagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.taskmanagement.Entity.Task;
import com.taskmanagement.Services.TaskServices;

@Controller
public class MainController {
    @Autowired
    private TaskServices taskServices;

    // http://localhost:8080/homepage
    @GetMapping("/homepage")
    public String homeHandler() {
        return "home";
    }

    // http://localhost:8080/addTask
    @GetMapping("/addTask")
    public String showAddTaskForm(@ModelAttribute("Task") Task task) {
        return "addtask";
    }

    @PostMapping("/addTask")
    public String addTaskHandler(@ModelAttribute("Task") Task task) {
        this.taskServices.addTask(task);
        return "redirect:/homepage";
    }
}
