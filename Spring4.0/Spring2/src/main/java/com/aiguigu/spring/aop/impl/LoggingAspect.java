package com.aiguigu.spring.aop.impl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//把这个类声明为一个切面:需要把该类放到IOC容器中，再声明为一个切面
@Component
@Aspect
public class LoggingAspect {

    //声明该方法是一个前置通知
    @Before("execution(public int com.aiguigu.spring.aop.impl.ArithmeticCaculator.add(int,int))")
    public void beforeMethod(JoinPoint joinPoint){
        String methodName=joinPoint.getSignature().getName();
        System.out.println(methodName);
        System.out.println("methodArgs"+ Arrays.asList(joinPoint.getArgs()));
        System.out.println("The Method begins ...");
    }

    //后置通知：在目标方法执行后（无论是否发生异常），执行通知
    //在后置通知中还不能访问目标方法的执行结果
    @After("execution(public int com.aiguigu.spring.aop.impl.ArithmeticCaculator.add(int,int))")
    public void AfterMethod(JoinPoint joinPoint){
        String methodName=joinPoint.getSignature().getName();
        System.out.println(methodName);
        System.out.println("methodArgs"+ Arrays.asList(joinPoint.getArgs()));
        System.out.println("The Method ends ...");
    }
}
