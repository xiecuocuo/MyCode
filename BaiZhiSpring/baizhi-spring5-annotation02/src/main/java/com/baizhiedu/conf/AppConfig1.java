package com.baizhiedu.conf;

import com.baizhiedu.dao.UserDAO;
import com.baizhiedu.service.UserService;
import com.baizhiedu.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:applicationContext.xml")
public class AppConfig1 {
    @Autowired
    private UserDAO userDAO;
    @Bean
    public UserService userService(){
        UserServiceImpl userService=new UserServiceImpl();
        userService.setUserDAO(userDAO);
        return userService;
    }
}
