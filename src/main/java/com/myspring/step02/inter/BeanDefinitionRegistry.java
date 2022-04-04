package com.myspring.step02.inter;


import com.myspring.step02.BeanDefinition;

public interface BeanDefinitionRegistry {
    void registerBeanDefintion(String name, BeanDefinition beanDefinition);
}
