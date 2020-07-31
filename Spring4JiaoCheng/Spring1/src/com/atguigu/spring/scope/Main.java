package com.atguigu.spring.scope;

import com.atguigu.spring.autowire.Car;
import com.atguigu.spring.autowire.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext act=new ClassPathXmlApplicationContext("beans-scope.xml");
        Car car1= (Car) act.getBean("car");
        Car car2= (Car) act.getBean("car");
        System.out.println(car1==car2);//scope=singleton,为true,scope=prototype,为false
    }
}
