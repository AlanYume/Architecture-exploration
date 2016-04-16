package com.niuhp.userlogin.service.impl;

import com.niuhp.userlogin.dao.UserDAO;
import com.niuhp.userlogin.domain.User;
import com.niuhp.userlogin.service.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {

    private UserDAO userDao;

    public UserDAO getUserDao() {
        return userDao;
    }

    public void setUserDao(final UserDAO userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUser(final User user) {
        userDao.save(user);
    }

    @Override
    public List<User> getUserList() {
        return userDao.findAll();
    }

    @Override
    public void deleteUser(final int id) {
        userDao.deleteById(id);
    }

    @Override
    public User userLogin(final String username, final String password) {
        return userDao.userLogin(username, password);
    }

    @Override
    public void modifyPassword(final int id, final String newPassword) {
        final Map<String, Object> cMap = new HashMap<String, Object>();
        cMap.put("id", id);
        final Map<String, Object> vMap = new HashMap<String, Object>();
        vMap.put("password", newPassword);
        userDao.udateByPropertyMap(cMap, vMap);
    }

}