package com.baizhiedu.service;

import com.baizhiedu.dao.UserDao;
import com.baizhiedu.mybatis.User;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class UserServiceImpl2 implements UserService {
    private UserDao userDao;
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    public void register(User user) throws Exception {
        userDao.addUser(user);
        throw new RuntimeException("测试");
    }
    public void login(){
    }
}
