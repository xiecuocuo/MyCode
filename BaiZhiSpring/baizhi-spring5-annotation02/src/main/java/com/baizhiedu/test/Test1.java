package com.baizhiedu.test;

import com.baizhiedu.Application;
import com.baizhiedu.aop.AopConfig;
import com.baizhiedu.bean.User;
import com.baizhiedu.conf.AppConfig1;
import com.baizhiedu.conf.AppConfig2;
import com.baizhiedu.conf.AppConfig3;
import com.baizhiedu.config.ApplicationConfig2;
import com.baizhiedu.config.ApplicationConfig3;
import com.baizhiedu.config.ApplicationConfig4;
import com.baizhiedu.dao.UserDAOImpl;
import com.baizhiedu.service.UserService;
import com.baizhiedu.service.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
    @Test
    public void test1(){
        ApplicationContext ctx=new AnnotationConfigApplicationContext(Application.class);
        System.out.println(ctx.getBean("user"));
        System.out.println(ctx.getBean("connection1"));
        System.out.println(ctx.getBean("connection2"));
    }
    @Test
    public void test2(){
        ApplicationContext ctx=new AnnotationConfigApplicationContext(Application.class);
        User user1= (User) ctx.getBean("user");
        User user2= (User) ctx.getBean("user");
        System.out.println(user1==user2);
    }
    @Test
    public void test3(){
        ApplicationContext ctx=new AnnotationConfigApplicationContext("com.baizhiedu");
        UserServiceImpl userService= (UserServiceImpl) ctx.getBean("userService");
        System.out.println(userService);
        System.out.println(userService.getUserDAO());
    }
    @Test
    public void test4(){
        ApplicationContext ctx=new AnnotationConfigApplicationContext("com.baizhiedu");
        User user= (User) ctx.getBean("user");
        System.out.println(user);
    }
    @Test
    public void test5(){
        ApplicationContext ctx=new AnnotationConfigApplicationContext(ApplicationConfig2.class);
        User user1= (User) ctx.getBean("user");
        System.out.println(user1);
    }
    @Test
    public void test6(){
        ApplicationContext ctx=new AnnotationConfigApplicationContext(ApplicationConfig3.class);
        UserService userService= (UserService) ctx.getBean("userService");
        userService.addUser(new User());
    }
    @Test
    public void test7(){
        ApplicationContext ctx=new AnnotationConfigApplicationContext(ApplicationConfig3.class, ApplicationConfig4.class);
        UserService userService= (UserService) ctx.getBean("userService");
        userService.addUser(new User());
    }
    @Test
    public void test8(){
        ApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig1.class);
        UserService userService= (UserService) ctx.getBean("userService");
        userService.addUser(new User());
    }
    @Test
    public void test9(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        User user= (User) ctx.getBean("user");
        System.out.println(user);
    }

    @Test
    public void test10(){
        ApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig3.class);
        User user= (User) ctx.getBean("user");
        System.out.println(user);
    }
}
