package com.baizhiedu.aop;

import com.baizhiedu.bean.User;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {
    public void register(User user){
        System.out.println("UserDAOImpl register");
    }
    public void login(User user){
        System.out.println("UserDAOImpl login");
    }
}
