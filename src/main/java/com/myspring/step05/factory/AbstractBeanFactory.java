package com.myspring.step05.factory;

import com.myspring.step04.Impl.BeanDefinition;
import com.myspring.step04.Impl.registry.DefaultSingletionBeanRegistry;
import com.myspring.step04.inter.BeanFactory;

public abstract class AbstractBeanFactory extends DefaultSingletionBeanRegistry implements BeanFactory {
//    @Override
//    public Object getBean(String name) {
//        // 获取bean
//        Object bean = getSingleton(name);
//        if(bean != null)
//            return bean;
//
//
//        BeanDefinition beanDefinition = getBeanDefinition(name);
//        return createBean(name,beanDefinition);
//
//    }


    @Override
    public Object getBean(String name, Object... args) {
        // 获取bean
        Object bean = getSingleton(name);
        if(bean != null)
            return bean;


        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name,beanDefinition,args);
    }



    protected abstract Object createBeanInstance(String name, BeanDefinition beanDefinition, Object... args);
    protected abstract BeanDefinition getBeanDefinition(String name);
    protected abstract Object createBean(String name, BeanDefinition beanDefinitio,Object ...args);

}
