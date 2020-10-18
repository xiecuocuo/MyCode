package com.atguigu.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorld {

    /*
    * 1.使用@RequestMapping 注解来映射请求的URL
    * 2.返回值会通过视图解析器解析为实际的物理视图,对于InternalResourceViewResolver视图解析器，会做如下解析：
    *   通过prefix+返回值+suffix 这样的方式得到的是实际的物理视图。
    *
    * */
    @RequestMapping("/helloWorld")
    public String helloWorld(){
        System.out.println("Hello World!");
        return "success";
    }
}
