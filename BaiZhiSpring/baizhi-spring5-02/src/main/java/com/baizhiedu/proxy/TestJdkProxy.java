package com.baizhiedu.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestJdkProxy {
    public static void main(String[] args) {
        //1.创建原始对象
        final UserService userService=new UserServiceImpl();
        //2.创建InvocationHandler
        InvocationHandler invocationHandler=new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("JDK动态代理前置处理");
                //执行原始方法的调用
                Object ret=method.invoke(userService,args);
                System.out.println("JDK动态代理后置处理");
                return ret;
            }
        };
        //3.获取代理对象
        UserService  userServiceProxy= (UserService) Proxy.newProxyInstance(TestJdkProxy.class.getClassLoader(),userService.getClass().getInterfaces(),invocationHandler);
        userServiceProxy.login("ynf","123");
        userServiceProxy.register("ynf","123");
    }
}
