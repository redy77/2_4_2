package ru.viktor.lesson231.dao;

import ru.viktor.lesson231.models.Roles;
import ru.viktor.lesson231.models.User;

import java.util.List;

public interface UserDao {
    List<User> getAll();

    User getUser(int id);

    void addUser(User user);

    void editUser(User user);

    void deleteUser(int id);

    User getUserByName(String name);

    void addRole(Roles roles);

    void editRole(Roles role);
    Roles getRole(int id);
    Roles getRoleByName(String role);


}
