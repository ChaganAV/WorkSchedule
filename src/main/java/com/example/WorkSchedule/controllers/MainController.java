package com.example.WorkSchedule.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String index(){
        return "index.html";
    }
    @GetMapping("/home")
    public String home(Model page){
        page.addAttribute("username","Katy");
        page.addAttribute("color","red");
        return "home.html";
    }
}
