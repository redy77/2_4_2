package ru.viktor.lesson231.dao;

import org.springframework.stereotype.Repository;
import ru.viktor.lesson231.models.Roles;
import ru.viktor.lesson231.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAll() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public User getUser(int id) {

        TypedQuery<User> query = entityManager.createQuery("select u from User u where u.id= :id", User.class);
        query.setParameter("id", id);
        return query.getResultList().stream().findAny().orElse(null);
    }

    @Override
    public Roles getRole(int id) {

        TypedQuery<Roles> query = entityManager.createQuery("select u from Roles u where u.id= :id", Roles.class);
        query.setParameter("id", id);
        return query.getResultList().stream().findAny().orElse(null);
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }


    @Override
    public void editUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public void editRole(Roles role) {
        entityManager.merge(role);
    }

    @Override
    public void deleteUser(int id) {
        entityManager.remove(getUser(id));
    }


    @Override
    public User getUserByName(String name) {
        TypedQuery<User> query = entityManager.createQuery("select u from User u where u.username= :name", User.class);
        query.setParameter("name", name);
        return query.getResultList().stream().findAny().orElse(null);
    }

    @Override
    public void addRole(Roles roles) {
        entityManager.persist(roles);
    }

    @Override
    public Roles getRoleByName(String role) {
        TypedQuery<Roles> query = entityManager.createQuery("select r from Roles r where r.role= :role", Roles.class);
        query.setParameter("role", role);
        return query.getResultList().stream().findAny().orElse(null);
    }
}
