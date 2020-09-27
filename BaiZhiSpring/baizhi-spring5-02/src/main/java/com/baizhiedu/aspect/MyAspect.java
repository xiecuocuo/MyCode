package com.baizhiedu.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/*
* 1.额外功能
* public class MyArround implements MethodInceptor
*   public Object invoke(MethodInvocation invocation){
*   }
*}
*
* 2.切入点
* <aop:config>
    <aop:pointcut id="ponintCut1" expression="execution(* com.baizhiedu.proxy..*.*(String,..))"/
* </aop:config>
* */
@Aspect
public class MyAspect {
    @Pointcut("execution(* login(..))")
    public void pointCut1(){};

    @Around("pointCut1()")
    public Object arround1(ProceedingJoinPoint proceedingJoinPoint   ){
        Object ret=null;
        try {
            System.out.println("MyAspect Before------");
            ret= proceedingJoinPoint.proceed();
            System.out.println("MyAspect After------");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return ret;
    }

    @Around("pointCut1()")
    public Object arround2(ProceedingJoinPoint proceedingJoinPoint   ){
        Object ret=null;
        try {
            System.out.println("MyAspect Before2------");
            ret= proceedingJoinPoint.proceed();
            System.out.println("MyAspect After2------");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return ret;
    }
}
