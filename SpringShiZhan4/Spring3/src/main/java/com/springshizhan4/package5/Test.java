package com.springshizhan4.package5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ctx=new AnnotationConfigApplicationContext(ExpressiveConfig.class);
//        ApplicationContext ctx=new ClassPathXmlApplicationContext("ctx.xml");
        BlankDisc blankDisc= (BlankDisc) ctx.getBean("disc");
        System.out.println(blankDisc);
    }
}
