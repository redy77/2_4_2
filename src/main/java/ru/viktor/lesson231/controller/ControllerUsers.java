package ru.viktor.lesson231.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.viktor.lesson231.models.User;
import ru.viktor.lesson231.service.UserService;

@Controller
@RequestMapping("/")
public class ControllerUsers {

    private final UserService userService;

    @Autowired
    public ControllerUsers(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String AllUsers(Model model) {
        model.addAttribute("users", userService.getAll());
        return "index";
    }

    @GetMapping("/{id}")
    public String User(@PathVariable("id") int id, Model model) {
        model.addAttribute(userService.getUser(id));
        return "user";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id, Model model) {
        userService.deleteUser(id);
        return "redirect:/";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user){
        userService.addUser(user);
        return "redirect:/";
    }
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.getUser(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user) {
        userService.editUser(user);
        return "redirect:/";
    }
}
