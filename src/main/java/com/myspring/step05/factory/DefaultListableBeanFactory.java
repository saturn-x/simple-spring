package com.myspring.step05.factory;

import com.myspring.step04.Impl.BeanDefinition;
import com.myspring.step04.inter.BeanDefinitionRegistry;
import com.myspring.step05.config.BeanException;

import java.util.HashMap;

public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {

    HashMap<String, BeanDefinition> hashMap = new HashMap<>();


    @Override
    protected BeanDefinition getBeanDefinition(String name) {
        BeanDefinition beanDefinition = hashMap.get(name);
        if(beanDefinition == null)
            throw new BeanException("bean 未定义！",new NullPointerException());
        return beanDefinition;
    }

    @Override
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        hashMap.put(name,beanDefinition);
    }


}
