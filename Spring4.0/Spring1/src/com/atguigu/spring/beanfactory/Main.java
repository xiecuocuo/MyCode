package com.atguigu.spring.beanfactory;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("beans-factorybean.xml");
        Car car= (Car) ctx.getBean("car");
        System.out.println(car);
    }
}
