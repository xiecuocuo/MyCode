package com.baizhiedu.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class TestCglibProxy {
    public static void main(String[] args) {
        //1.创建原始对象
        final UserServiceImpl userService=new UserServiceImpl();
        //2.通过cglib动态代理对象(cglib的相关jar包由Spring默认引入)
        //类似于 Proxy.newProxyInstance(TestJdkProxy.class.getClassLoader(),userService.getClass().getInterfaces(),invocationHandler);
        Enhancer enhancer=new Enhancer();
        enhancer.setClassLoader(TestCglibProxy.class.getClassLoader());
        enhancer.setSuperclass(UserServiceImpl.class);
        MethodInterceptor methodInterceptor=new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                System.out.println("Cglib 动态代理前置处理");
                Object ret =  method.invoke(userService,args);
                System.out.println("Cglib 动态代理后置处理");
                return ret;
            }
        };
        enhancer.setCallback(methodInterceptor);
        UserServiceImpl userServiceProxy= (UserServiceImpl) enhancer.create();
        userServiceProxy.login("ynf","123");
        userServiceProxy.register("ynf","123");
    }
}
