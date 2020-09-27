package com.baizhiedu.proxy;

import com.baizhiedu.annotation.Log;

public class UserServiceImpl implements UserService {
    @Log
    public void register(String username, String password) {
        System.out.println("UserName:"+username+",PassWord:"+password+" register!");
    }

    public boolean login(String username, String password) {
        System.out.println("UserName:"+username+",PassWord:"+password+" login!");
        return true;
    }
}
