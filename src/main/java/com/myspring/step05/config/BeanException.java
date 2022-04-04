package com.myspring.step05.config;

public class BeanException extends RuntimeException{
    String situation;
    Exception e;
    public BeanException(String situation,Exception e) {
        System.out.println("异常为" + situation);
        e.printStackTrace();
    }
}
