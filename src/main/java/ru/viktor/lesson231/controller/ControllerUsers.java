package ru.viktor.lesson231.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class ControllerUsers {

    @GetMapping()
    public String showUsers(){
        return "users/index";
    }
}
