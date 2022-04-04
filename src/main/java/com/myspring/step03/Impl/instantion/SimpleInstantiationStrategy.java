package com.myspring.step03.Impl.instantion;

import com.myspring.step03.BeanDefinition;
import com.myspring.step03.BeanException;
import com.myspring.step03.inter.instantation.InstantiationStrategy;

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
            throw new BeanException("Failed to instantiate [" + clazz.getName() + "]");
        }
    }

}
 