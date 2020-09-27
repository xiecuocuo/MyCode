package com.atguigu.test;

import com.atguigu.aop.MathCaculator;
import com.atguigu.config.MainConfigAop;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AOP_Test {
    @Test
    public void test1(){
        ApplicationContext context=new AnnotationConfigApplicationContext(MainConfigAop.class);
        MathCaculator mathCaculator= (MathCaculator) context.getBean("mathCaculator");
        mathCaculator.div(10,0);
    }
}
