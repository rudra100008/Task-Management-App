package com.taskmanagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;
import com.taskmanagement.Entity.Task;
import com.taskmanagement.Services.TaskServices;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.servlet.view.RedirectView;



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
    @GetMapping("/stickywall")
    public String stickyWallHandler(Model model) {
        List<Task> fetchTask=this.taskServices.fetchTasks();
        model.addAttribute("tasks", fetchTask);
         return "taskdisplay";
    }
    @GetMapping("/delete/{id}")
    public RedirectView deleteHandler(@PathVariable("id") int id,HttpServletRequest request) 
    {
        this.taskServices.deleteTaskById(id);
        RedirectView redirectView =new RedirectView();
        redirectView.setUrl(request.getContextPath()+"/stickywall");
        return redirectView;
    }
    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable("id") int id,Model model)
    {
        Task task =this.taskServices.findTaskById(id);
        model.addAttribute("tasks", task);
        return "update";
    }
    @PostMapping("/update")
    public String updateHandler(@ModelAttribute("Task")Task task)
    {
        this.taskServices.updateTask(task);
        return "redirect:/stickywall";
    }
    
    

    
}
