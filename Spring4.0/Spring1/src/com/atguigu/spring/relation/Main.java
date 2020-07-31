package com.atguigu.spring.relation;

import com.atguigu.spring.autowire.Address;
import com.atguigu.spring.autowire.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext act=new ClassPathXmlApplicationContext("beans-relation.xml");
/*        Address address1= (Address) act.getBean("address1");
        System.out.println(address1);
        Address address2= (Address) act.getBean("address2");
        System.out.println(address2);
        Address address3= (Address) act.getBean("address3");
        System.out.println(address3);*/
        Person person=(Person) act.getBean("person");
        System.out.println(person);
    }
}
