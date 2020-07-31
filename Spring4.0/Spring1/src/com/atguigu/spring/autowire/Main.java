package com.atguigu.spring.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext act=new ClassPathXmlApplicationContext("beans.xml");
        Person person= (Person) act.getBean("person");
        System.out.println(person);
    }
}
