package com.myspring.step03.Impl;

import com.myspring.step03.BeanDefinition;
import com.myspring.step03.inter.BeanFactory;

public abstract class AbstractBeanFactory extends DefaultSingletionBeanRegistry implements BeanFactory {
    @Override
    public Object getBean(String name) {
        // 获取bean
        Object bean = getSingleton(name);
        if(bean != null)
            return bean;


        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name,beanDefinition);

    }


    @Override
    public Object getBean(String name, Object... args) {
        // 获取bean
        Object bean = getSingleton(name);
        if(bean != null)
            return bean;


        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBeanInstance(name,beanDefinition,args);
    }



    protected abstract Object createBeanInstance(String name, BeanDefinition beanDefinition, Object[] args);
    protected abstract BeanDefinition getBeanDefinition(String name);
    protected abstract Object createBean(String name, BeanDefinition beanDefinition);

}
