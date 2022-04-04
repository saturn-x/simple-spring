package com.myspring.step02;

public class BeanException extends RuntimeException{
    public BeanException(String situation) {
        System.out.println("异常为" + situation);
    }
}
