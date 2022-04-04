package com.myspring.step05.impl;


import com.myspring.step05.config.PropertyValues;

/*
    关于Bean 定义
    主要是Class 对象 以及 属性对象
 */
public class BeanDefinition {

    Class beanClass;

    PropertyValues proPertyValues;

    /*
这里可以防止空指针
 */

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
        this.proPertyValues = new PropertyValues();
    }
    public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.proPertyValues = propertyValues != null ? propertyValues : new PropertyValues();
    }
    public Class getBeanClass() {
        return beanClass;
    }

    public PropertyValues getPropertyValues() {
        return proPertyValues;
    }

}
