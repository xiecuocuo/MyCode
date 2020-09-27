package com.atguigu.test;

import com.atguigu.config.MainConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest2 {
    public static void main(String[] args) {
        ApplicationContext ctx=new AnnotationConfigApplicationContext(MainConfig.class);
        //获取在Spring容器中的所有Bean名字
        String[] names= ctx.getBeanDefinitionNames();
        for(String name:names){
            System.out.println(name);
        }
    }
}
