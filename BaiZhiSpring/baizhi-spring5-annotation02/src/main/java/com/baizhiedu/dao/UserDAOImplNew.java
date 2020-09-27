package com.baizhiedu.dao;

import com.baizhiedu.bean.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImplNew implements UserDAO {
    public void addUser(User user){
        System.out.println("UserDAOImplNew 添加用户"+user);
    }
}
