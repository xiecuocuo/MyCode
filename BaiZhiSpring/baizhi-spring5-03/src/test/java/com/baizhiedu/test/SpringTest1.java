package com.baizhiedu.test;

import com.baizhiedu.dao.UserDao;
import com.baizhiedu.mybatis.User;
import com.baizhiedu.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest1 {
    @Test
    public void test1(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao= (UserDao) applicationContext.getBean("userDao");
        userDao.addUser(new User("niuweiwei","abc1234"));
    }
    @Test
    public void test2(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService= (UserService) applicationContext.getBean("userService");
        try {
            userService.register(new User("maweiwei4","abc1234"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test3(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService= (UserService) applicationContext.getBean("userService2");
        try {
            userService.register(new User("maweiwei4","abc1234"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
