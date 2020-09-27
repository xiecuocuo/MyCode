package com.baizhidu.dynamic;

import com.baizhidu.proxy.UserService;

public class UserServiceImpl implements UserService {
    public void register(String username, String password) {
        System.out.println("UserName:"+username+",PassWord:"+password+" register!");
    }

    public boolean login(String username, String password) {
        return true;
    }
}
