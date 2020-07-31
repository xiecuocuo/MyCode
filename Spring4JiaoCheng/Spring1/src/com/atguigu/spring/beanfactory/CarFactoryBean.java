package com.atguigu.spring.beanfactory;

import org.springframework.beans.factory.FactoryBean;

public class CarFactoryBean implements FactoryBean<Car> {
    private String brand;

    public void setBrand(String brand) {
        this.brand = brand;
    }

    //返回Bean对象
    @Override
    public Car getObject() throws Exception {
        return new Car(brand,500000);
    }
    //返回Bean的类型
    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }
    //返回是否单例
    @Override
    public boolean isSingleton() {
        return false;
    }
}
