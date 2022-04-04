package com.myspring.step03.inter;


// 通过参数来实例化 bean
public interface BeanFactory {
    // beanfactory 主要功能是获取bean
    Object getBean(String name);
    Object getBean(String name, Object... args);

}
