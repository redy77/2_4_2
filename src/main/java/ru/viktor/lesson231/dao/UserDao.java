package ru.viktor.lesson231.dao;

import ru.viktor.lesson231.models.User;

import java.util.List;

public interface UserDao {
    List <User> getAll();
    User getUser(Long id);
    void addUser(User user);
    void editUser(String name, int age, String email);
    void deleteUser(Long id);

}
