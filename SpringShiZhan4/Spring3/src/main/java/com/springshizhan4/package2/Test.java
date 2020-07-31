package com.springshizhan4.package2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ctx=new AnnotationConfigApplicationContext(JavaConfig.class);
        MagicBean magicBean= (MagicBean) ctx.getBean("magicBean");
        System.out.println(magicBean);
    }
}
