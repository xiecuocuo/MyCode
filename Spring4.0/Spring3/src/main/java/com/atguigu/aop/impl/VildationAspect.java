package com.atguigu.aop.impl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
@Order(1)
public class VildationAspect {
    //声明该方法是一个前置通知
    @Before("com.atguigu.aop.impl.LoggingAspect.loggingOperation()")
    public void vildation(JoinPoint joinPoint){
        String methodName=joinPoint.getSignature().getName();
        System.out.println("VildationAspect前置通知开始-----------");
        System.out.println(methodName);
        System.out.println("methodArgs"+ Arrays.asList(joinPoint.getArgs()));
        System.out.println("The Method begins ...");
        System.out.println("VildationAspect前置通知结束-----------");
    }
}
