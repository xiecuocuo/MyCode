package cn.ynf.bean;

import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class KinghtMain {
    public static void main(String[] args) {
        //加载Spring上下文
//        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(KinghtConfig.class);
//        ApplicationContext context=new FileSystemXmlApplicationContext("D:\\GitCode\\SpringShiZhan4\\Spring1\\resource\\applicationContext.xml");
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取KnightBean
        Knights knight=context.getBean(Knights.class);
        //使用KnightBean
        knight.embarkOnQuest();
    }
}
