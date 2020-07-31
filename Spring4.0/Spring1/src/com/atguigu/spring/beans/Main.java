package com.atguigu.spring.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        //1.创建SpringIOC容器
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        //2.从IOC容器中获取Bean实例
        //利用id定位到IOC容器中的bean
        HelloWold helloWold= (HelloWold) applicationContext.getBean("helloWorld");
        //利用类型反射IOC容器中的bean,但要求IOC容器中只能有一个该类型的Bean
        HelloWold helloWold1=applicationContext.getBean(HelloWold.class);
        //3.调用hello方法
        helloWold.hello();
        Car car= (Car) applicationContext.getBean("car1");
        System.out.println(car);

        Person person= (Person) applicationContext.getBean("person3");
        System.out.println(person);
    }
}
