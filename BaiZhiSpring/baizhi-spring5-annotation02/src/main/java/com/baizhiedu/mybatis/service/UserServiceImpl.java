package com.baizhiedu.mybatis.service;

import com.baizhiedu.bean.User;
import com.baizhiedu.mybatis.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;
    @Override
    public void addUser(User user) {
        userDAO.addUser(user);
        int a=1/0;
    }
}
