package com.myspring.step03;

public class BeanDefinition {

    Class beanClass;
    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }

    public Class getBeanClass() {
        return beanClass;
    }
}
