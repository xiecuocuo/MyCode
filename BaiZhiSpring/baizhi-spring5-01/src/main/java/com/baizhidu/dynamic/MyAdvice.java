package com.baizhidu.dynamic;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class MyAdvice implements MethodBeforeAdvice {
    //作用：需要把运行的原始纺织系之前运行的额外功能书写在before方法中
    /*
    * Method:额外功能所增加给的那个原始方法。比如login、register
    * Object[]:额外功能所增加给的那个原始方法的参数。
    * Object: 额外功能所增加给的那个原始对象
    * */
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("MyAdvice before log--------");
    }
    /*
    * MethodBeforeAdvice接口作用：额外功能运行在原始方法执行之前，进行额外功能操作。
    * */
}
