package ru.viktor.lesson231.config;

import org.springframework.stereotype.Component;
import ru.viktor.lesson231.models.Roles;
import ru.viktor.lesson231.models.User;
import ru.viktor.lesson231.service.UserService;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.Set;

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

        User user = new User("Tom", "1", 34, "tom@tom.ru", Set.of(role, role1));
        User user1 = new User("Ket", "1", 34, "tom@tom.ru", Set.of(role1));
        userService.addUser(user);
        userService.addUser(user1);
//        User user1 = new User("Ket", 23, "ket@tom.ru");
//        userService.addUser(user1);
//        User user2 = new User("Liz", 38, "liz@tom.ru");
//        userService.addUser(user2);
//        User user3 = new User("Bill", 32, "bill@tom.ru");
//        userService.addUser(user3);
//


    }
}