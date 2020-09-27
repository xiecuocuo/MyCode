package com.baizhidu.proxy;

public class UserServiceProxy implements UserService {
    private UserServiceImpl userService=new UserServiceImpl();

    public void register(String username, String password) {
        System.out.println("注册操作日志开始");
        userService.register(username,password);
        System.out.println("注册操作日志结束");
    }

    public boolean login(String username, String password) {
        System.out.println("登录操作开始");
        return userService.login(username,password);
    }
}
