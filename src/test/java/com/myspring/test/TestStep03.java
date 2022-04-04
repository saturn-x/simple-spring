package com.myspring.test;

import com.myspring.step03.BeanDefinition;
import com.myspring.step03.Impl.DefaultListableBeanFactory;
import com.myspring.test.bean.UserService;
import org.junit.Test;

public class TestStep03 {
    @Test
    public void test_BeanFactory() {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. 注入bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefintion("userService", beanDefinition);

        // 3.获取bean
        UserService userService = (UserService) beanFactory.getBean("userService", "hello 呀");
        userService.queryInfo();
    }
}
