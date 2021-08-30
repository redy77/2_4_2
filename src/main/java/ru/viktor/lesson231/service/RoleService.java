package ru.viktor.lesson231.service;

import ru.viktor.lesson231.models.Roles;

import java.util.List;

public interface RoleService {
    void addRole(Roles roles);

    Roles getRole(int id);

    List<Roles> getListRoles();
}
