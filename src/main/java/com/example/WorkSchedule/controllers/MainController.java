package com.example.WorkSchedule.controllers;

import com.example.WorkSchedule.services.LoggedUserManagementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    private final LoggedUserManagementService loggedUserManagementService;

    public MainController(LoggedUserManagementService loggedUserManagementService) {
        this.loggedUserManagementService = loggedUserManagementService;
    }
    @GetMapping("/main")
    public String home(@RequestParam(required = false) String Logout,
                       Model model){
        if (Logout != null){
            loggedUserManagementService.setUsername(null);
        }

        String username = loggedUserManagementService.getUsername();
        if(username == null){
            return "redirect:/";
        }
        model.addAttribute("username", username);
        return "main.html";
    }

    @GetMapping("/index")
    public String index(){
        return "index.html";
    }
    @GetMapping("/home")
    public String home2(Model page){
        page.addAttribute("username","Katy");
        page.addAttribute("color","red");
        return "home.html";
    }
}
