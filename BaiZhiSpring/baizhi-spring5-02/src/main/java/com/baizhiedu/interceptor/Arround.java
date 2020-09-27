package com.baizhiedu.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class Arround implements MethodInterceptor {
    /*
    * invoke方法的作用：额外功能书写在invoke中
    * 额外功能：
    *   原始方法之前
    *   原始方法之后
    *   原始方法前后
    * 确定原始方法怎样运行？
    * 参数：MethodInvocation:额外功能所增加给的那个原始方法
    * 返回值：额外功能所增加给的那个原始方法的返回值。如果原始方法返回值类型为void,那么result为Null
    * */
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("前置额外功能");
        //原始方法执行
        Object result=methodInvocation.proceed();
        System.out.println("后置额外功能");
        return result;
    }
}
