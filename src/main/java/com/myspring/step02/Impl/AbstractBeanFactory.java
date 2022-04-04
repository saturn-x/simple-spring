package com.myspring.step02.Impl;

import com.myspring.step02.BeanDefinition;
import com.myspring.step02.inter.BeanFactory;

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


    protected abstract BeanDefinition getBeanDefinition(String name);
    protected abstract Object createBean(String name,BeanDefinition beanDefinition);

}
