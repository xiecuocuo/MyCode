package com.atguigu.test;

import com.atguigu.bean.Yellow;
import com.atguigu.config.MainConfigAutoWire;
import com.atguigu.config.MainConfigProfile;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

public class IOC_Test_Profile {
    @Test
    public void test1(){
        AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
        //1、创建一个applicationContext
        //2、设置需要激活的环境
        ctx.getEnvironment().setActiveProfiles("dev","test");
        //3、注册主配置类
        ctx.register(MainConfigProfile.class);
        //4、启动刷新容器
        ctx.refresh();
        String[] namesForType = ctx.getBeanNamesForType(DataSource.class);
        for (String string : namesForType) {
            System.out.println(string);
        }

        Yellow bean = ctx.getBean(Yellow.class);
        System.out.println(bean);
        ctx.close();
    }
}
