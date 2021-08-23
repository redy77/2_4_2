package ru.viktor.lesson231.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.viktor.lesson231.dao.UserDaoImpl;
import ru.viktor.lesson231.models.User;

@Controller
@RequestMapping("/users")
public class ControllerUsers {

    UserDaoImpl userDao = new UserDaoImpl();

    @GetMapping()
    public String showUsers(){
        userDao.addUser(new User("we", 87, "kjhkj"));
        return "users";
    }
}
