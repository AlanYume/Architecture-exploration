package com.foo.jason.dao.impl;

import com.foo.jason.dao.UserDao;
import com.foo.jason.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void saveUser(final User user) {
        entityManager.persist(user);
    }

    public void deleteUserById(final int id) {
        final User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    public User getUserById(final int id) {
        return entityManager.find(User.class, id);
    }

    public ArrayList<User> getListUsers() {
        final Query query = entityManager.createQuery("from User");
        return Cast.castList(User.class, query.getResultList());
    }

    public void setEntityManager(final EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}