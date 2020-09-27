package com.baizhiedu.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
    @Pointcut("execution(* com.baizhiedu.aop.UserServiceImpl.*(..))")
    public void pointCut1(){};

    @Around("pointCut1()")
    public Object arround1(ProceedingJoinPoint proceedingJoinPoint){
        Object ret=null;
        try {
            System.out.println("MyAspect Before------");
            Object[] args=proceedingJoinPoint.getArgs();//获取原始方法形参
            ret= proceedingJoinPoint.proceed(args);
            System.out.println("MyAspect After------");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return ret;
    }
}
