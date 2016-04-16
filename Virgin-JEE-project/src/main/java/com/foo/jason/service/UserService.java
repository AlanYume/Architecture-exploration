package com.foo.jason.service;

import com.foo.jason.entity.User;

import java.util.ArrayList;

public interface UserService {

    void saveUser(User user);

    void deleteUserById(int id);

    User getUserById(int id);

    ArrayList<User> getListUsers();

}