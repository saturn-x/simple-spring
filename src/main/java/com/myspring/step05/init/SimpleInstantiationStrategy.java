package com.myspring.step05.init;

import com.myspring.step05.inter.instantation.InstantiationStrategy;
import com.myspring.step05.config.BeanException;
import com.myspring.step05.impl.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SimpleInstantiationStrategy implements InstantiationStrategy {

    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeanException {
        Class clazz = beanDefinition.getBeanClass();
        try {
            if (null != ctor) {
                return clazz.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
            } else {
                return clazz.getDeclaredConstructor().newInstance();
            }
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException  | InvocationTargetException e) {
            throw new BeanException("Failed to instantiate [" + clazz.getName() + "]",e);
        }
    }

}
 