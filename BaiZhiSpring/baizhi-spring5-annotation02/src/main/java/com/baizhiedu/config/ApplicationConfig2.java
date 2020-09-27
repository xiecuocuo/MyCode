package com.baizhiedu.config;

import com.baizhiedu.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import javax.annotation.Resource;

@Configuration
@ComponentScan(basePackages = {"com.baizhiedu"})
@ImportResource("classpath:applicationContext.xml")
public class ApplicationConfig2 {
    @Bean
    public User user(){
        User user=new User();
        user.setUsername("ynf2");
        user.setPassword("abc2");
        return user;
    }
}
