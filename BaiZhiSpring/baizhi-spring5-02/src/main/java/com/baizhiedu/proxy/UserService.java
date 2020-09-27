package com.baizhiedu.proxy;

public interface UserService {
    public void register(String username,String password);
    public boolean login(String username,String password);
}
