package cn.edu.bupt.dao.impl;

import cn.edu.bupt.dao.UserDaoI;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("userDao")
public class UserDaoImpl<T> implements UserDaoI<T> {

    @Autowired
    private SessionFactory sessionFactory;

    public Serializable save(final T o) {
        // TODO Auto-generated method stub
        return sessionFactory.getCurrentSession().save(o);
    }


}
