package com.baizhiedu.bean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Product {
    public Product() {
        System.out.println("Product Creat");
    }
    @PostConstruct
    public void init(){
        System.out.println("init");
    }
    @PreDestroy
    public void destory(){
        System.out.println("destory");
    }
}
