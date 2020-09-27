package com.atguigu.test;

import com.atguigu.config.MainConifgLifeCycle;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_LifeCycle {

    @Test
    public void test1(){
        //1.创建IOC容器
        AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(MainConifgLifeCycle.class);
        System.out.println("容器创建完成....");
        //关闭容器
        ctx.close();
    }
}
