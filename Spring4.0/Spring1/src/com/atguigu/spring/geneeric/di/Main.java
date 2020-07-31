package com.atguigu.spring.geneeric.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx=new ClassPathXmlApplicationContext("beans-generic.di.xml");

        UserService userService= (UserService) ctx.getBean("userService");
        userService.add();
        RoleService roleService= (RoleService) ctx.getBean("roleService");
        roleService.add();
    }
}
/*
运行结果：
add...
com.atguigu.spring.geneeric.di.UserReponsitory@9a7504c
add...
com.atguigu.spring.geneeric.di.RoleReponsitory@2c039ac6*/
