package com.baizhiedu;

import com.baizhiedu.bean.User;
import com.baizhiedu.dao.UserDAO;
import com.baizhiedu.dao.UserDAOImpl;
import com.baizhiedu.factorybean.ConnectionFactoryBean;
import com.baizhiedu.service.UserService;
import com.baizhiedu.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import java.sql.Connection;
import java.sql.DriverManager;

@Configuration
@PropertySource("classpath:init.properties")
@ComponentScan(basePackages = {"com.baizhiedu"})
public class Application {
    @Value("${username}")
    private String username;
    @Value("${password}")
    private String password;
/*    @Bean("user")
    @Scope("prototype")
    public User getUser(){
        return new User();
    }*/
    @Bean("connection1")
    public Connection conn1(){
        Connection conn=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","ynf");
        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }
    @Bean("connection2")
    public Connection conn2(){
        Connection conn=null;
        try{
            conn=new ConnectionFactoryBean().getObject();
        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }
    @Bean("userDao")
    public UserDAO getUserDao(){
        return new UserDAOImpl();
    }
    @Bean("userService")
    public UserService getUserService(){
        UserServiceImpl userSerice=new UserServiceImpl();
        userSerice.setUserDAO(getUserDao());
        return userSerice;
    }
    @Bean
    public User user(){
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        return user;
    }
}
