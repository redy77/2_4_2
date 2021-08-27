package ru.viktor.lesson231.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.viktor.lesson231.models.Roles;
import ru.viktor.lesson231.models.User;
import ru.viktor.lesson231.service.UserService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class LoginController {
//    @RequestMapping( "/")
//    public String getHomePage(Model model) {
//        List<String> messages = new ArrayList<>();
//        messages.add("Hello!");
//        messages.add("I'm Spring MVC-SECURITY application");
//        messages.add("This is Root Page");
//        model.addAttribute("messages", messages);
//        return "helloPage";
//    }

    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "login")
    public String getLoginPage() {
        return "login";
    }



    @GetMapping("index")
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
        return "redirect:/index";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute("user") User user,
                              @RequestParam(required=false) String roleAdmin,
    @RequestParam(required=false) String role_USER){
        Set<Roles> roles = new HashSet<>();
        roles.add(userService.getRoleByName("ROLE_USER"));
        if (roleAdmin != null && roleAdmin.equals("ROLE_ADMIN")) {
            roles.add(userService.getRoleByName("ROLE_ADMIN"));
        }
        user.setRoles(roles);
        userService.addUser(user);
        return "redirect:/index";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.getUser(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user) {
        userService.editUser(user);
        return "redirect:/index";
    }
}
