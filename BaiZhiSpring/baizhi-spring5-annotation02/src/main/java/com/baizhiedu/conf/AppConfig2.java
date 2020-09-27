package com.baizhiedu.conf;

import com.baizhiedu.dao.UserDAO;
import com.baizhiedu.dao.UserDAOImpl;
import com.baizhiedu.service.UserService;
import com.baizhiedu.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig2 {
    @Bean
    public UserDAO userDAO(){
        return new UserDAOImpl();
    }
}
