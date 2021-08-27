package ru.viktor.lesson231.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.viktor.lesson231.dao.UserDao;
import ru.viktor.lesson231.models.Roles;
import ru.viktor.lesson231.models.User;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public User getUser(int id) {
        return userDao.getUser(id);
    }

    @Override

    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override

    public void editUser(User user) {
        userDao.editUser(user);
    }

    @Override

    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

    @Override
    public User getUserByName(String name) {
        return userDao.getUserByName(name);
    }

    @Override

    public void addRole(Roles roles) {
        userDao.addRole(roles);
    }

    @Override
    public void editRole(Roles role) {
        userDao.editRole(role);
    }

    @Override
    public Roles getRole(int id) {
        return userDao.getRole(id);
    }

    @Override
    public Roles getRoleByName(String role) {
        return userDao.getRoleByName(role);
    }
}
