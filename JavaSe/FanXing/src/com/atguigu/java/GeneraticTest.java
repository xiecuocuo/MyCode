package com.atguigu.java;

import org.junit.Test;

import java.util.*;

/*
*
* 泛型的使用：
* 1、JDK1.5新增特性
* 2.在集合中使用泛型：
* 总结：
* 1.集合接口或集合类在jdk5.0时都修改为带泛型的结构
* 2.在实例化集合类时，可以指明具体的泛型类型
* 3。指明完以后，在集合类或接口中凡是定义类或接口时，内部结构（比如：方法、构造器、属性等）使用到类的泛型的位置，都指定为实例化的泛型类型。
*    比如：add(E e)  --->实例化以后：add(Integer e)
* 4.注意点：泛型的类型必须是类，不能是基本数据类型。需要用到基本数据类型的位置，拿包装类替换
* 5.如果实例化时，没有指明泛型的类型。默认类型为java.lang.Object类型。
* */
public class GeneraticTest {
    //在集合中使用泛型之前的情况
    @Test
    public void test1(){
        ArrayList list=new ArrayList();
        //存放学生的成绩
        list.add(89);
        list.add(89);
        list.add(89);
        list.add(89);
        //问题1：类型不安全
        list.add("Tom");
        for(Object score:list){
            //问题2：强转时有可能出现类型转换异常ClassCastException
            int stuScore= (int) score;
            System.out.println(score);
        }
    }
    //在集合中使用泛型的情况：以ArrayList为例
    @Test
    public void test2(){
        ArrayList<Integer> list=new ArrayList<Integer>();//不能是基本数据类型，只能是包装类
        //存放学生的成绩
        list.add(89);
        list.add(89);
        list.add(89);
        list.add(89);//如果在类上加泛型，方法如果也涉及该泛型则，要求一致
//        list.add("Tom");编译就会进行类型检查，保证数据安全
        //方式1：
//        for(Integer score:list){
//            //避免了强转操作，进而不会出现类型转换异常
//            int stuScore=score;
//            System.out.println(score);
//        }
        Iterator<Integer> iterator=list.iterator();
        while(iterator.hasNext()){
            Integer a=iterator.next();
            System.out.println(a);
        }
    }
    //在集合中使用泛型的情况：以HashMap为例
    @Test
    public void test3(){
        //jdk7新特性：类型推断
        Map<String,Integer> map = new HashMap<>();
        map.put("张三",123);
        map.put("张三",123);
        map.put("张三",123);
//        map.put(123,"abc");

        Set<Map.Entry<String,Integer>> entrySet=map.entrySet();//泛型的嵌套
        Iterator<Map.Entry<String,Integer>> iterator=entrySet.iterator();
        while (iterator.hasNext()){
            Map.Entry<String,Integer> entry=iterator.next();
            System.out.println("key: "+entry.getKey()+" , "+"value: "+entry.getValue());
        }
    }
}
