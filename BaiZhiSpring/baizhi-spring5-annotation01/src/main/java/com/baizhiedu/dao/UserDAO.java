package com.baizhiedu.dao;

import com.baizhiedu.bean.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {
    public void addUser(User user){
        System.out.println("添加用户"+user);
    }
}
