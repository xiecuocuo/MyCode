package com.baizhiedu.factory;

public interface UserService {
    public void register(String username, String password);
    public boolean login(String username, String password);
}
