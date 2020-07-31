package com.atguigu.aop.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        //1.创建SpringIoc容器
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        //2.从IOC容器中获取bean实例
        ArithmeticCaculator arithmeticCaculator= (ArithmeticCaculator)ctx.getBean("arithmeticCaculator");
        //3.使用Bean
        int result2=arithmeticCaculator.div(1000,10);
        System.out.println(result2);
    }
}
