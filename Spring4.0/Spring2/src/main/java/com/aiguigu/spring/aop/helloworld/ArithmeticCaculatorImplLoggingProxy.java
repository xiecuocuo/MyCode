package com.aiguigu.spring.aop.helloworld;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ArithmeticCaculatorImplLoggingProxy {

    //要代理的对象
    private ArithmeticCaculatorImpl target;

    public ArithmeticCaculatorImplLoggingProxy(ArithmeticCaculatorImpl target) {
        this.target = target;
    }

    public ArithmeticCaculator getLoggingProxy(){
        ArithmeticCaculator proxy=null;
        //代理对象由哪一个类加载器负责加载
        ClassLoader loader=target.getClass().getClassLoader();
        //代理对象的类型，即其中有哪些方法
        Class[] interfaces=target.getClass().getInterfaces();
        InvocationHandler handler=new InvocationHandler() {
            /*
                proxy:为正在返回的那个代理对象，一般情况下，在invoke方法中都不使用该对象
                method:正在被调用的方法
                args:调用方法时，传入的参数
            * */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("The method "+method.getName()+" begins with "+ Arrays.toString(args));
                //当代理对象调用真实对象的方法时，其会自动的跳转到代理对象关联的handler对象的invoke方法来进行调用
                Object returnValue = method.invoke(target, args);
                System.out.println("The method "+method.getName()+" end with "+ Arrays.toString(args));
                return returnValue;
            }
        };
        proxy= (ArithmeticCaculator) Proxy.newProxyInstance(loader,interfaces,handler);
        return proxy;
    }
}
