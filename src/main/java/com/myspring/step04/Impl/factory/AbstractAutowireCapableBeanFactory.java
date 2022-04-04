package com.myspring.step04.Impl.factory;

import com.myspring.step05.config.BeanException;
import com.myspring.step04.Impl.BeanDefinition;
import com.myspring.step04.Impl.BeanReference;
import com.myspring.step04.Impl.instantion.CglibSubclassingInstantiationStrategy;
import com.myspring.step04.Impl.property.PropertyValue;
import com.myspring.step04.Impl.property.PropertyValues;
import com.myspring.step04.inter.instantation.InstantiationStrategy;
import cn.hutool.core.bean.BeanUtil;
import java.lang.reflect.Constructor;

/*
    实现通过使用 属性注入
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {


    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();
    @Override
    protected Object createBean(String name, BeanDefinition beanDefinition,Object...args){
        // 通过beanDefintion 中的class 文件实例化bean
        Object bean = null;
        // 1.创建Bean
        bean = createBeanInstance(name,beanDefinition,args);
        // 2.注册属性
        applyPropertyValues(name, bean, beanDefinition);
        addSingleton(name,beanDefinition);
        return bean;
    }


    @Override
    protected Object createBeanInstance(String name, BeanDefinition beanDefinition, Object[] args) {
        Constructor constructorToUse = null;
        Class<?> beanClass = beanDefinition.getBeanClass();
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        for (Constructor ctor : declaredConstructors) {
            if (null != args && ctor.getParameterTypes().length == args.length) {
                constructorToUse = ctor;
                break;
            }
        }
        return getInstantiationStrategy().instantiate(beanDefinition, name, constructorToUse, args);
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void applyPropertyValues(String beanName,Object obj,BeanDefinition beanDefinition) {
        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {

                String name = propertyValue.getName();
                Object value = propertyValue.getValue();
//                System.out.println("获取name" + "vlaue" +name+" "+ value);
                if (value instanceof BeanReference) {
                    // A 依赖 B，获取 B 的实例化
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }
                // 属性填充
                BeanUtil.setFieldValue(obj, name, value);
            }
        } catch (Exception e) {
            throw new BeanException("Error setting property values：" + beanName);
        }
    }



}
