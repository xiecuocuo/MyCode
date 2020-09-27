package com.baizhiedu.service;

import com.baizhiedu.dao.UserDao;
import com.baizhiedu.mybatis.User;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor = {java.lang.Exception.class},noRollbackFor = {java.lang.RuntimeException.class})
public class UserServiceImpl implements UserService {
    private UserDao userDao;
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    public void register(User user) throws Exception {
        userDao.addUser(user);
        throw new Exception("测试");
    }
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public void login(){
    }
}
