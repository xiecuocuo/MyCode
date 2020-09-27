package com.baizhiedu.test;

import com.baizhiedu.bean.User;
import com.baizhiedu.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Test1 {
    @Test
    public void test1(){
        ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println(ctx.getBean("product"));
        ctx.close();
    }
    @Test
    public void test2(){
        ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        User user= (User) ctx.getBean("user");
        System.out.println(user);
    }
    @Test
    public void test3(){
        ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        String[] strs=ctx.getBeanDefinitionNames();
        for(String str:strs){
            System.out.println(str);
        }
    }
    @Test
    public void test4(){
        ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService= (UserService) ctx.getBean("userService");
        System.out.println(userService);
    }
}
