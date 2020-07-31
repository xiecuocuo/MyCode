package com.atguigu.spring.factory;

import java.util.HashMap;
import java.util.Map;
/*
实例工厂方法：实例工厂的方法，即先创建工厂本身，再调用工厂的实例方法来返回bean的实例
* */
public class InstanceCarFactory {
    private static Map<String,Car> carMap=null;
    public InstanceCarFactory(){
        carMap=new HashMap<String,Car>();
        carMap.put("Audi",new Car("Audi",300000));
        carMap.put("Ford",new Car("Ford",340000));
    }
    //实例工厂方法
    public Car getCar(String name){
        return carMap.get(name);
    }
}
