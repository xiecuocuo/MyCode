package com.baizhiedu.test;

import com.baizhiedu.aop.AopConfig;
import com.baizhiedu.aop.UserService;
import com.baizhiedu.bean.User;
import com.baizhiedu.mybatis.SpringMybatisConfig;
import com.baizhiedu.mybatis.TransacitonalConfig;
import com.baizhiedu.mybatis.dao.UserDAO;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test2 {
    @Test
    public void test1(){
        ApplicationContext ctx=new AnnotationConfigApplicationContext(AopConfig.class);
        UserService userService= (UserService) ctx.getBean("userService");
        userService.login(new User());
        userService.register(new User());
    }
    @Test
    public void test2(){
        ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringMybatisConfig.class);
        UserDAO userDAO= (UserDAO) ctx.getBean("userDAO");
        User user=new User();
        user.setUsername("mingbu1");
        user.setPassword("abc1");
        userDAO.addUser(user);
    }
    @Test
    public void test3(){
        ApplicationContext ctx=new AnnotationConfigApplicationContext("com.baizhiedu.mybatis");
        com.baizhiedu.mybatis.service.UserService userService= (com.baizhiedu.mybatis.service.UserService) ctx.getBean("userService");
        User user=new User();
        user.setUsername("mingbu2");
        user.setPassword("abc2");
        userService.addUser(user);
    }
    @Test
    public void test4(){
        ApplicationContext ctx=new AnnotationConfigApplicationContext("com.baizhiedu.yml");
        User user= (User) ctx.getBean("user");
        System.out.println(user);
    }
}
