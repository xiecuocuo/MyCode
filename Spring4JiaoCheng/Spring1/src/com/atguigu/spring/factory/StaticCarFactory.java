package com.atguigu.spring.factory;

import java.util.HashMap;
import java.util.Map;

/*
静态工厂方法：直接调用某一个类的静态方法就可以返回Bean的实例
* */
public class StaticCarFactory {
    private static Map<String,Car> carMap=new HashMap<String,Car>();
    static{
        carMap.put("Audi",new Car("Audi",300000));
        carMap.put("Ford",new Car("Ford",340000));
    }
    //静态工厂方法
    public static Car getCar(String name){
        return carMap.get(name);
    }
}
