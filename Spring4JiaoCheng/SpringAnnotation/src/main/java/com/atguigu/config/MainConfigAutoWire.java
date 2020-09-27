package com.atguigu.config;

import com.atguigu.dao.BookDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan("com.atguigu")
public class MainConfigAutoWire {
    @Bean("bookDao2")
    public BookDao BookDao(){
        BookDao bookDao=new BookDao();
        bookDao.setLabel("2");
        return bookDao;
    }
}
