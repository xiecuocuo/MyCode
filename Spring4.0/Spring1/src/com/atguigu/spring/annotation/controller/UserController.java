package com.atguigu.spring.annotation.controller;

import com.atguigu.spring.annotation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    @Autowired(required = false)
    private UserService userService;

    public void excute(){
        System.out.println("UserController excute ......");
        userService.service();
    }
}
