package com.atguigu.spring.annotation.service;

import com.atguigu.spring.annotation.reponsitory.UserResponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
@Service
public class UserService {
    private UserResponsitory userResponsitory;
    @Autowired

    public void setUserResponsitory(@Qualifier("userResponsitoryImpl")UserResponsitory userResponsitory) {
        this.userResponsitory = userResponsitory;
    }

    public void service(){
        System.out.println("UserService execute....");
        userResponsitory.save();
    }
}
