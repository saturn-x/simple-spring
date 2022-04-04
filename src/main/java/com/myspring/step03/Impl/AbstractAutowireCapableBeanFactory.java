package com.myspring.step03.Impl;

import com.myspring.step03.BeanDefinition;
import com.myspring.step03.Impl.instantion.CglibSubclassingInstantiationStrategy;
import com.myspring.step03.inter.instantation.InstantiationStrategy;

import java.lang.reflect.Constructor;

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {


    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();
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


//    @Override
//    protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) {
//        Constructor constructorToUse = null;
//        Class<?> beanClass = beanDefinition.getBeanClass();
//        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
//        for (Constructor ctor : declaredConstructors) {
//            if (null != args && ctor.getParameterTypes().length == args.length) {
//                constructorToUse = ctor;
//                break;
//            }
//        }
//        return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructorToUse, args);
//    }


    @Override
    protected Object createBeanInstance(String name, BeanDefinition beanDefinition, Object[] args) {
        Constructor constructorToUse = null;
        Class<?> beanClass = beanDefinition.getBeanClass();
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        for (Constructor ctor : declaredConstructors) {
            if (null != args && ctor.getParameterTypes().length == args.length) {
                constructorToUse = ctor;
                break;
            }
        }
        return getInstantiationStrategy().instantiate(beanDefinition, name, constructorToUse, args);
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }
}
