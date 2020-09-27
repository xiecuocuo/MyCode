package com.baizhiedu.proxy;

public interface OrderService {
    public void register(String username,String password);
    public boolean login(String username,String password);
}
