package com.myspring.step04.Impl.registry;

import com.myspring.step04.inter.SingletonBeanRegistry;

import java.util.HashMap;

public class DefaultSingletionBeanRegistry implements SingletonBeanRegistry {
    // 缓存存放 单例bean
    HashMap<String,Object> singletonObjects = new HashMap<>();


    @Override
    public Object getSingleton(String name) {
        return singletonObjects.get(name);
    }

    public void addSingleton(String name,Object object) {
        singletonObjects.put(name,object);
    }
}
