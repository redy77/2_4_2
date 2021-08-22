package ru.viktor.lesson231.dao;

import ru.viktor.lesson231.models.User;

import java.util.List;

public interface UserDao {
    List <User> addAll();
    User addUser(Long id);
    void setUser();
    void editUser();
    void deleteUser();

}
