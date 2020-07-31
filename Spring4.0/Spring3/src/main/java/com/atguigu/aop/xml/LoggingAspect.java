package com.atguigu.aop.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//把这个类声明为一个切面:需要把该类放到IOC容器中，再声明为一个切面
public class LoggingAspect {
    public void loggingOperation(){};

    //声明该方法是一个前置通知
    public void beforeMethod(JoinPoint joinPoint){
        String methodName=joinPoint.getSignature().getName();
        System.out.println("LoggingAspect前置通知开始-----------");
        System.out.println(methodName);
        System.out.println("methodArgs"+ Arrays.asList(joinPoint.getArgs()));
        System.out.println("The Method begins ...");
        System.out.println("LoggingAspect前置通知结束-----------");
    }

    //后置通知：在目标方法执行后（无论是否发生异常），执行通知
    //在后置通知中还不能访问目标方法的执行结果
    public void afterMethod(JoinPoint joinPoint){
        String methodName=joinPoint.getSignature().getName();
        System.out.println("后置通知开始-----------");
        System.out.println(methodName);
        System.out.println("methodArgs"+ Arrays.asList(joinPoint.getArgs()));
        System.out.println("The Method ends ...");
        System.out.println("后置通知结束-----------");
    }


//    返回通知：在方法正常结束受执行的代码，然通知是可以访问到方法返回值的
    public void afterReturningMethod(JoinPoint joinPoint,Object result){
        System.out.println("返回通知开始-----------");
        String methodName=joinPoint.getSignature().getName();
        System.out.println("The method"+methodName+" ends with "+result);
        System.out.println("返回通知结束-----------");
    }


//    在目标方法出现异常是执行的代码
//    可以访问到异常对象；且可以指定在出现特定异常时执行通知的代码
    public void afterThrowingMethod(JoinPoint joinPoint,Exception e){
        System.out.println("异常通知开始-----------");
        String methodName=joinPoint.getSignature().getName();
        System.out.println("The method"+methodName+" occurs exception "+e);
        System.out.println("异常通知结束-----------");
    }
 /*   环绕通知需要携带ProcceedingJoinPoint参数
    环绕通知类似于动态代理的全过程：ProcceedingJoinPoint类型参数可以决定是否执行目标方法
    且环绕通知必须有返回值，返回值即为目标方法的返回值*/
    public Object aroundMethod(ProceedingJoinPoint proceedingJoinPoint){
        Object result=null;
        String methodName=proceedingJoinPoint.getSignature().getName();
        try{
            //前置通知
            System.out.println(methodName+" 前置通知 >>>>>>>>>>>");
            result=proceedingJoinPoint.proceed();
            //返回通知
            System.out.println(methodName+" 返回通知 >>>>>>>>>>>");
        }catch (Throwable throwable) {
            //异常通知
            System.out.println(methodName+" 异常通知 >>>>>>>");
            throwable.printStackTrace();
        }
        //后置通知
        System.out.println(methodName+" 后置通知 >>>>>>>");
        return result;
    }
}
