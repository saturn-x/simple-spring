package com.myspring.step04.inter;


import com.myspring.step04.Impl.BeanDefinition;

public interface BeanDefinitionRegistry {
    void registerBeanDefinition(String name, BeanDefinition beanDefinition);
}
