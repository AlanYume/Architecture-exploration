package com.niuhp.userlogin.service;

import com.niuhp.userlogin.domain.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    List<User> getUserList();

    void deleteUser(int id);

    User userLogin(String username, String password);

    void modifyPassword(int id, String newPassword);
}
