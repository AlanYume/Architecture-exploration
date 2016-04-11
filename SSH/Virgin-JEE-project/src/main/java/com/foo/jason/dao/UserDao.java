package com.foo.jason.dao;

import com.foo.jason.entity.User;

import java.util.ArrayList;

public interface UserDao {

    void saveUser(User user);

    void deleteUserById(int id);

    User getUserById(int id);

    ArrayList<User> getListUsers();

}