package com.baizhiedu.config;

import com.baizhiedu.dao.UserDAO;
import com.baizhiedu.dao.UserDAOImpl;
import com.baizhiedu.service.UserService;
import com.baizhiedu.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages = {"com.baizhiedu"})
public class ApplicationConfig3 {
    @Bean
    public UserDAO userDAO(){
        return new UserDAOImpl();
    }
    @Bean
    public UserService userService(){
        UserServiceImpl userService=new UserServiceImpl();
        userService.setUserDAO(userDAO());
        return userService;
    }
}
