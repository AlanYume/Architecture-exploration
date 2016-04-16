package com.beanPostProcessor;

import dps.bean.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyBeanPostProcessor.class);

    @Override
    public Object postProcessAfterInitialization(final Object bean, final String beanName)
            throws BeansException {
        LOGGER.info("Bean后处理器在初始化之前对" + beanName + "进行增强处理");
        return bean;
    }

    @Override
    public Object postProcessBeforeInitialization(final Object bean, final String beanName)
            throws BeansException {
        LOGGER.info("Bean后处理器在初始化之后对" + beanName + "进行增强处理");
        //如果该bean是Person类的实例，则改变其属性值
        if (bean instanceof Person) {
            final Person p = (Person) bean;
            p.setName("段鹏松");
        }
        return bean;
    }
}
