package com.myspring.test;

import com.myspring.step02.BeanDefinition;
import com.myspring.step01.BeanFactory;
import com.myspring.step02.Impl.DefaultListableBeanFactory;
import com.myspring.test.bean.UserService;
import org.junit.Test;

import javax.jws.soap.SOAPBinding;

public class ApiTest {

//    @Test
//    public void testStep01() {
//        BeanFactory beanFactory = new BeanFactory();
//        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
//        beanFactory.registerBeanDefinition("userService",beanDefinition);
//        UserService userService = (UserService) beanFactory.getBean("userService");
//        userService.queryInfo();
//    }

    @Test
    public void testStep02() {
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
//        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        defaultListableBeanFactory.registerBeanDefintion("userService",null);
        UserService userService =(UserService) defaultListableBeanFactory.getBean("userService");
        userService.queryInfo();

    }
}
