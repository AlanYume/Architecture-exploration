package com.beanFactoryProcessor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyBeanFactoryPostProcessor.class);

    @Override
    public void postProcessBeanFactory(final ConfigurableListableBeanFactory beanFactory)
            throws BeansException {
        LOGGER.info("程序对Spring所做的BeanFactory的初始化没有改变");
        LOGGER.info("spring的容器是" + beanFactory);
    }
}
