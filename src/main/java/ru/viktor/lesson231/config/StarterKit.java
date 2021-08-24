package ru.viktor.lesson231.config;

import org.springframework.stereotype.Component;
import ru.viktor.lesson231.models.User;
import ru.viktor.lesson231.service.UserService;

import javax.annotation.PostConstruct;

@Component
public class StarterKit {

    private final UserService userService;

    public StarterKit(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    private void init() {
        User user = new User("Tom", 34, "tom@tom.ru");
        userService.addUser(user);
        User user1 = new User("Ket", 23, "ket@tom.ru");
        userService.addUser(user1);
        User user2 = new User("Liz", 38, "liz@tom.ru");
        userService.addUser(user2);
        User user3 = new User("Bill", 32, "bill@tom.ru");
        userService.addUser(user3);
    }
}
