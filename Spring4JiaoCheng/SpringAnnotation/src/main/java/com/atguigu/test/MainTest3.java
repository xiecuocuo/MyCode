package com.atguigu.test;

import com.atguigu.bean.Person;
import com.atguigu.config.MainConfig3;
import com.atguigu.config.MainConfigOfPropertyValue;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest3 {
    ApplicationContext ctx=new AnnotationConfigApplicationContext(MainConfig3.class);
    @Test
    public void testCondition(){
        //Person person1= (Person) ctx.getBean("person1");
        Person person2= (Person) ctx.getBean("person2");
//      System.out.println(person1);
        System.out.println(person2);
    }
    @Test
    public void testImport(){
        String[] beans=ctx.getBeanDefinitionNames();
        for(String bean:beans){
            System.out.println(bean);
        }
    }
    @Test
    public void testFactoryBean(){
        //工厂Bean获取的是调用getObject创建的对象
        Object bean1 = ctx.getBean("colorFactory");
        Object bean2 = ctx.getBean("colorFactory");
        System.out.println("bean的类型："+bean1.getClass());
        System.out.println(bean1 == bean2);

        Object bean3 = ctx.getBean("&colorFactory");
        System.out.println(bean3.getClass());
    }
    @Test
    public void testValue(){
        ApplicationContext ctx=new AnnotationConfigApplicationContext(MainConfigOfPropertyValue.class);
        Person person= (Person) ctx.getBean("person");
        System.out.println(person);
    }
}
