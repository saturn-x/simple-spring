package com.myspring.step02.Impl;

import com.myspring.step02.BeanDefinition;
import com.myspring.step02.BeanException;
import com.myspring.step02.inter.BeanDefinitionRegistry;

import java.util.HashMap;

public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {

    HashMap<String, BeanDefinition> hashMap = new HashMap<>();

    @Override
    protected BeanDefinition getBeanDefinition(String name) {
        BeanDefinition beanDefinition = hashMap.get(name);
        if(beanDefinition == null)
            throw new BeanException("bean 未定义！");
        return beanDefinition;
    }

    @Override
    public void registerBeanDefintion(String name, BeanDefinition beanDefinition) {
        hashMap.put(name,beanDefinition);
    }
}
