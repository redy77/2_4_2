package ru.viktor.lesson231.service;

import ru.viktor.lesson231.models.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User getUser(Long id);
    void addUser(User user);
    void editUser(String name, int age, String email);
    void deleteUser(Long id);
}
