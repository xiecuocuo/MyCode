package com.atguigu.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/*
* 切面类：告诉Spring这是一个切面
* @Aspect： 告诉Spring当前类是一个切面类
* */
@Aspect
public class LogAspects {
    //抽取公共的切入点表达式
    //1、本类引用
    //2、其他的切面引用
    @Pointcut("execution(public int com.atguigu.aop.MathCaculator.*(..))")
    public void pointCut(){};

    //@Before在目标方法之前切入；切入点表达式（指定在哪个方法切入）
    @Before("com.atguigu.aop.LogAspects.pointCut()")
    public void logStart(JoinPoint joinPoint){
        Object[] args=joinPoint.getArgs();
        System.out.println(joinPoint.getSignature().getName()+"运行。。。@Before:参数列表是："+ Arrays.toString(args));
    }

    @After("com.atguigu.aop.LogAspects.pointCut()")
    public void logEnd(JoinPoint joinPoint){
        System.out.println(""+joinPoint.getSignature().getName()+"结束。。。@After");
    }
    //JoinPoint一定要出现在参数表的第一位
    @AfterReturning(value = "com.atguigu.aop.LogAspects.pointCut()",returning = "result")
    public void logReturn(JoinPoint joinPoint,Object result){
        System.out.println(joinPoint.getSignature().getName()+"正常返回。。。@AfterReturning:运行结果：{"+result+"}");
    }

    @AfterThrowing(value = "com.atguigu.aop.LogAspects.pointCut()",throwing = "exception")
    public void logThrowing(JoinPoint joinPoint,Exception exception){
        System.out.println(""+joinPoint.getSignature().getName()+"异常。。。异常信息：{"+exception+"}");
    }

    /*@Around(value = "com.atguigu.aop.LogAspects.pointCut()")
    public Object logArround(ProceedingJoinPoint proceedingJoinPoint){
        Object result=null;
        //执行方法
        try {
            System.out.println("前置通知");
            result=proceedingJoinPoint.proceed();
            System.out.println("返回通知");
        } catch (Throwable throwable) {
            System.out.println("异常通知");
            throwable.printStackTrace();
        }
        System.out.println("后置通知");
        return result;
    }*/
}
