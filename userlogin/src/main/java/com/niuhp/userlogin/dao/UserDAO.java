package com.niuhp.userlogin.dao;

import com.niuhp.userlogin.domain.User;

public interface UserDAO extends BaseDao<User> {

    User userLogin(String username, String password);
}
