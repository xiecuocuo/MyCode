package com.atguigu.test;

import com.atguigu.bean.Person;
import com.atguigu.config.MainConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest {
    public static void main(String[] args) {
        ApplicationContext ctx=new AnnotationConfigApplicationContext(MainConfig.class);
        Person person= (Person) ctx.getBean("person");
        System.out.println(person);
        //获取Person类在Spring容器中的所有名字
        String[] names= ctx.getBeanNamesForType(Person.class);
        for(String name:names){
            System.out.println(name);
        }
    }
}
