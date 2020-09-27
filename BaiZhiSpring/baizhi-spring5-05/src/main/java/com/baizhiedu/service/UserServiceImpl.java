package com.baizhiedu.service;

import com.baizhiedu.bean.User;
import com.baizhiedu.dao.UserDao;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void register(User user) {
        userDao.addUser(user);
    }
}
