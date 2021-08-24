package ru.viktor.lesson231.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.viktor.lesson231.dao.UserDao;
import ru.viktor.lesson231.dao.UserDaoImpl;
import ru.viktor.lesson231.models.User;
import ru.viktor.lesson231.service.UserService;

@Controller
@RequestMapping("/user")
public class ControllerUsers {

    UserService userService;

    @Autowired
    public ControllerUsers(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String showUsers() {
//        userService.addUser(new User("we", 87, "kjhkj"));
        return "users";
    }
}
