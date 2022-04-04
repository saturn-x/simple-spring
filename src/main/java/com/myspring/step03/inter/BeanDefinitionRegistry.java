package com.myspring.step03.inter;


import com.myspring.step03.BeanDefinition;

public interface BeanDefinitionRegistry {
    void registerBeanDefintion(String name, BeanDefinition beanDefinition);
}
