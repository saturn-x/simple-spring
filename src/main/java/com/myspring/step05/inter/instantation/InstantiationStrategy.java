package com.myspring.step05.inter.instantation;

import com.myspring.step05.impl.BeanDefinition;
import com.myspring.step05.config.BeanException;

import java.lang.reflect.Constructor;

public interface InstantiationStrategy {
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeanException;
}
