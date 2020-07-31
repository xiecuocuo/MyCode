package com.springshizhan4.package4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ctx=new AnnotationConfigApplicationContext(JavaConfig.class);
        NotePad notePad1= (NotePad) ctx.getBean("notePad");
        NotePad notePad2= (NotePad) ctx.getBean("notePad");
        System.out.println(notePad1==notePad2);
    }
}
