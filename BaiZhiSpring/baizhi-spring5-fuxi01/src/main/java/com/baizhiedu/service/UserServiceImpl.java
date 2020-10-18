package com.baizhiedu.service;

import com.baizhiedu.bean.User;
import com.baizhiedu.dao.UserDao;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class UserServiceImpl implements UserSerivce {
    private UserDao userDao;
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void register(User user) {
        int a=1/0;
        userDao.addUser(user);
    }
}
