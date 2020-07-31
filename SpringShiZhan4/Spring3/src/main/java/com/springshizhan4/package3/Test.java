package com.springshizhan4.package3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ctx=new AnnotationConfigApplicationContext(JavaConfig.class);
        DessertBox dessertBox= (DessertBox) ctx.getBean("dessertBox");
        dessertBox.info();
    }
}
