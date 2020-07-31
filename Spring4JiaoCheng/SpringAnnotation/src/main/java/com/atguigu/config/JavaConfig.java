package com.atguigu.config;

import com.atguigu.bean.Person;
import com.atguigu.controller.BookController;
import com.atguigu.dao.BookDao;
import com.atguigu.filter.MyTypeFilter;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

//配置类==配置文件
@Configuration
@ComponentScans(value ={
    @ComponentScan(value = "com.atguigu",excludeFilters = {@ComponentScan.Filter(type = FilterType.CUSTOM,classes ={MyTypeFilter.class})}),
})
//@ComponentScan  value:指定要扫描的包
//excludeFilters = Filter[] ：指定扫描的时候按照什么规则排除那些组件
//includeFilters = Filter[] ：指定扫描的时候只需要包含哪些组件
//FilterType.ANNOTATION：按照注解
//FilterType.ASSIGNABLE_TYPE：按照给定的类型；
//FilterType.ASPECTJ：使用ASPECTJ表达式
//FilterType.REGEX：使用正则指定
//FilterType.CUSTOM：使用自定义规则
public class JavaConfig {//告诉Spring这是一个配置类
    //给容器中注册一个Bean;类型为返回值的类型，id默认是用方法名作为id
}
