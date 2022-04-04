package com.myspring.step04.inter.instantation;

import com.myspring.step04.Impl.BeanDefinition;
import com.myspring.step05.config.BeanException;

import java.lang.reflect.Constructor;

public interface InstantiationStrategy {
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeanException;
}
