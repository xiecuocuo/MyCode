package com.aiguigu.spring.aop.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        //1.创建SpringIoc容器
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        //2.从IOC容器中获取bean实例
        ArithmeticCaculator arithmeticCaculator= (ArithmeticCaculator)ctx.getBean("arithmeticCaculatorImpl");
        //3.使用Bean
        System.out.println(arithmeticCaculator.add(1,40));
    }
}
