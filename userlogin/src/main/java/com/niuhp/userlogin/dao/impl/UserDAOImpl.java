package com.niuhp.userlogin.dao.impl;

import com.niuhp.userlogin.dao.UserDAO;
import com.niuhp.userlogin.domain.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDAOImpl extends BaseDaoImpl<User> implements UserDAO {

    @Override
    public User userLogin(final String username, final String password) {
        final Map<String, Object> propMap = new HashMap<String, Object>();
        propMap.put("username", username);
        propMap.put("password", password);
        final List<User> users = findByPropertyMap(propMap);
        if (users != null && users.size() == 1) {
            return users.get(0);
        }
        return null;
    }

}
