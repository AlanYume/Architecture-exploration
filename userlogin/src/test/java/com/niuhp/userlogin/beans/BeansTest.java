package com.niuhp.userlogin.beans;

import com.niuhp.userlogin.domain.User;
import com.niuhp.userlogin.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Random;

public class BeansTest {

    private static ApplicationContext ctx;

    @Before
    public void init() {
        ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml",
                "classpath:bean-dao.xml",
                "classpath:bean-service.xml", "classpath:bean-action.xml");
    }

    @Test
    public void testBeans() {
        final Random r = new Random();
        final UserService us = ctx.getBean("userService", UserService.class);
        final User u = new User();
        u.setUsername("user" + r.nextInt(100));
        u.setPassword(u.getUsername());
        us.addUser(u);
        u.setNickname("user");
        System.out.println("------------" + u.getId());
    }
}
