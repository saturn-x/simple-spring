package com.myspring.test;


import com.myspring.step04.Impl.BeanDefinition;
import com.myspring.step04.Impl.BeanReference;
import com.myspring.step04.Impl.factory.DefaultListableBeanFactory;
import com.myspring.step04.Impl.property.PropertyValue;
import com.myspring.step04.Impl.property.PropertyValues;
import com.myspring.test.bean.UserDao;
import com.myspring.test.bean.UserService;
import org.junit.Test;

public class TestStep04 {

    @Test
    public void test() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.registerBeanDefinition("userService", new BeanDefinition(UserService.class));
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryInfo();
    }
    /*
    *
    * 测试属性注入
    * */
    @Test
    public void test2() {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));
        // 创建 属性list
        PropertyValues pvs = new PropertyValues();
        pvs.addPropertyValue(new PropertyValue("uId","10001"));
        // 通过 检测 如果也是一个bean 的话 就先实例依赖的bean
        pvs.addPropertyValue(new PropertyValue("userDao",new BeanReference("userDao")));

        beanFactory.registerBeanDefinition("userService",new BeanDefinition(
                UserService.class,pvs
        ));
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryInfo();

    }
}
