package com.foo.jason.service.impl;

import com.foo.jason.dao.UserDao;
import com.foo.jason.entity.User;
import com.foo.jason.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.ArrayList;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Inject
    public void setUserDao(final UserDao examenDao) {
        this.userDao = examenDao;
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void saveUser(final User user) {
        userDao.saveUser(user);
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void deleteUserById(final int id) {
        userDao.deleteUserById(id);
    }

    public User getUserById(final int id) {
        return userDao.getUserById(id);
    }

    public ArrayList<User> getListUsers() {
        return userDao.getListUsers();
    }
}
