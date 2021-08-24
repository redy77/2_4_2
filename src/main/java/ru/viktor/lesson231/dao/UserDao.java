package ru.viktor.lesson231.dao;

import ru.viktor.lesson231.models.User;

import java.util.List;

public interface UserDao {
    List <User> getAll();
    User getUser(int id);
    void addUser(User user);
    void editUser(User user);
    void deleteUser(int id);

}
