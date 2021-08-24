package ru.viktor.lesson231.service;

import ru.viktor.lesson231.models.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User getUser(int id);
    void addUser(User user);
    void editUser(User user);
    void deleteUser(int id);
}
