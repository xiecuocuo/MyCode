package com.baizhiedu.config;

import com.baizhiedu.dao.UserDAO;
import com.baizhiedu.dao.UserDAOImpl;
import com.baizhiedu.service.UserService;
import com.baizhiedu.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;


@Configuration
@ImportResource("classpath:applicationContext.xml")
public class ApplicationConfig4 {
}
