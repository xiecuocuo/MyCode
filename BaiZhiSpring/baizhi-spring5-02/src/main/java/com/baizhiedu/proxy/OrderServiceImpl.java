package com.baizhiedu.proxy;

public class OrderServiceImpl implements OrderService {
    public void register(String username, String password) {
        System.out.println("UserName:"+username+",PassWord:"+password+" register!");
    }

    public boolean login(String username, String password) {
        System.out.println("UserName:"+username+",PassWord:"+password+" login!");
        return true;
    }
}
