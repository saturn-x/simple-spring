package com.myspring.step03.inter.instantation;

import com.myspring.step03.BeanDefinition;
import com.myspring.step03.BeanException;

import java.lang.reflect.Constructor;

public interface InstantiationStrategy {
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeanException;
}
