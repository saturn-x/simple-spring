package com.myspring.step02.Impl;

import com.myspring.step02.BeanDefinition;

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{
    @Override
    protected Object createBean(String name, BeanDefinition beanDefinition){
        // 通过beanDefintion 中的class 文件实例化bean
        Object bean = null;
        try {
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        addSingleton(name,beanDefinition);
        return bean;
    }
}
