package com.baizhiedu.aspect;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class UserServiceImpl implements UserService, ApplicationContextAware {
    private ApplicationContext ctx;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ctx=applicationContext;
    }

    public void register(String username, String password) {
        System.out.println("UserName:"+username+",PassWord:"+password+" register!");
        UserService userService= (UserService) ctx.getBean("userService");
        userService.login(username, password);
    }

    public boolean login(String username, String password) {
        System.out.println("UserName:"+username+",PassWord:"+password+" login!");
        return true;
    }
}
