package com.baizhidu.life;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Product implements InitializingBean, DisposableBean {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("Product setName");
        this.name = name;
    }

    public Product() {
        System.out.println("Product constructor");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("Product afterPropertiesSet");
    }

    public void initProduct(){
        System.out.println("Product initProduct");
    }

    public void destroy() throws Exception {
        System.out.println("Product destroy");
    }
    public void close(){
        System.out.println("Product close");
    }
}
