package com.atguigu.test;

import com.atguigu.config.MainConfigAutoWire;
import com.atguigu.service.BookService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_Autowired {
    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigAutoWire.class);
        BookService bookService= (BookService) applicationContext.getBean("bookService");
        System.out.println(bookService);
        applicationContext.close();
    }

}
