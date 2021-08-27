package ru.viktor.lesson231.config;

import org.springframework.stereotype.Component;
import ru.viktor.lesson231.models.Roles;
import ru.viktor.lesson231.models.User;
import ru.viktor.lesson231.service.UserService;

import javax.annotation.PostConstruct;
import java.util.*;

@Component
public class StarterKit {


    private final UserService userService;

    public StarterKit(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    private void init() {

        Roles role = new Roles("ROLE_ADMIN");
        userService.addRole(role);
        Roles role1 = new Roles("ROLE_USER");
        userService.addRole(role1);
        User user = new User("1", "1", 34, "tom@tom.ru", Set.of(role, role1));
        User user1 = new User("Ket", "1", 34, "tom@tom.ru", Set.of(role1));
        userService.addUser(user);
        userService.addUser(user1);

    }
}