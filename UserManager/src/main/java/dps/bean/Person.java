package dps.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

public class Person implements InitializingBean {
    private static final Logger LOGGER = LoggerFactory.getLogger(Person.class);

    private String name;

    public void setName(final String name) {
        LOGGER.info("Spring 执行依赖关系注入------setName方法");
        this.name = name;
    }

    public Person() {
        LOGGER.info("Spring 实例化bean :Person bean实例------Person构造函数");
    }

    public void information() {
        LOGGER.info("这个人的名字是：" + name);
    }

    public void init() {
        LOGGER.info("正在执行初始化 ----------- init方法");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        LOGGER.info("正在执行 ----------- afterPropertiesSet方法");
    }
}
