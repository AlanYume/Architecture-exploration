package cn.edu.bupt.service;

import cn.edu.bupt.dao.UserDaoI;
import cn.edu.bupt.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
@Transactional
public class UserService {

    @Autowired
    private UserDaoI<User> userDao;

    public void addUser(final User user) {
        userDao.save(user);
    }
}
