package com.atguigu.spring.annotation;

import com.atguigu.spring.annotation.controller.UserController;
import com.atguigu.spring.annotation.reponsitory.UserResponsitory;
import com.atguigu.spring.annotation.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx=new ClassPathXmlApplicationContext("beans-annotation.xml");
/*        TestObject to= (TestObject) ctx.getBean("testObject");
        System.out.println(to);

        UserResponsitory userResponsitory= (UserResponsitory) ctx.getBean("userResponsitory");
        System.out.println(userResponsitory);

        UserService userService= (UserService) ctx.getBean("userService");
        System.out.println(userService);*/

        UserService userService= (UserService) ctx.getBean("userService");
        System.out.println(userService);

        userService.service();
    }
}
