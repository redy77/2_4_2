package ru.viktor.lesson231.dao;

import ru.viktor.lesson231.models.Roles;
import java.util.List;

public interface RoleDao {
    void addRole(Roles roles);

    Roles getRole(int id);

    List <Roles> getListRoles();

}
