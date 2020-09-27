package com.baizhiedu.aop;

import com.baizhiedu.bean.User;

public interface UserDAO {
    public void register(User user);
    public void login(User user);
}
