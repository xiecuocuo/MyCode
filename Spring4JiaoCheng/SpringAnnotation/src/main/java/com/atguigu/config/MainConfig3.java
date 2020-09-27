package com.atguigu.config;

import com.atguigu.bean.*;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

@Configuration
//@Import(Color.class)//导入单个组件
@Import({Color.class,MyImportSelector.class,MyImportBeanDefinitionRegistrar.class})//导入多个组件
public class MainConfig3 {
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Person person1(){
        Person person=new Person("Bill Gates",20);
        return person;
    }

    @Bean
    @Conditional(WindowsConditiion.class)
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Person person2(){
        Person person=new Person("Linux",20);
        return person;
    }

    @Bean
    public ColorFactory colorFactory(){
        return new ColorFactory();
    }
}
