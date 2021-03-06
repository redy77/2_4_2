package ru.viktor.lesson231.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.viktor.lesson231.dao.RoleDao;
import ru.viktor.lesson231.models.Roles;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    RoleDao roleDao;

    @Autowired
    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public void addRole(Roles roles) {
        roleDao.addRole(roles);
    }

    @Override
    public Roles getRole(Long id) {
        return roleDao.getRole(id);
    }

    @Override
    public List<Roles> getListRoles(){
        return roleDao.getListRoles();
    }
}
