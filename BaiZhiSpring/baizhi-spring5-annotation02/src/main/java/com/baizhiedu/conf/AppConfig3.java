package com.baizhiedu.conf;

import com.baizhiedu.bean.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

@Configuration
@ComponentScan(basePackages = "com.baizhiedu.conf")//扫描到@Value注解才能赋值成功
public class AppConfig3 {
    @Value("${username}")
    private String username;
    @Value("${password}")
    private String password;

    @Bean
    public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer=new PropertySourcesPlaceholderConfigurer();
        propertySourcesPlaceholderConfigurer.setLocation(new ClassPathResource("init.properties"));
        return propertySourcesPlaceholderConfigurer;
    }

    @Bean
    public User user(){
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        return user;
    }
}
