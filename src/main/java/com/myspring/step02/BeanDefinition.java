package com.myspring.step02;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.util.HashMap;

public class BeanDefinition {

    Class beanClass;
    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }

    public Class getBeanClass() {
        return beanClass;
    }
}
