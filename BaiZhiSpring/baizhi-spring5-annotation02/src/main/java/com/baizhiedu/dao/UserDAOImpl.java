package com.baizhiedu.dao;

import com.baizhiedu.bean.User;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class UserDAOImpl implements UserDAO {
    public void addUser(User user){
        System.out.println("UserDAOImpl 添加用户"+user);
    }
}
