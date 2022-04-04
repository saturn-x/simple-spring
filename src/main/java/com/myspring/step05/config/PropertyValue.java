package com.myspring.step05.config;

public class PropertyValue {
    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }

    private String name;

    private Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(Object value) {
        this.value = value;
    }

}