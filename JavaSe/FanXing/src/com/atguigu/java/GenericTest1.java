package com.atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/*
* 如何自定义泛型结构：泛型类、泛型接口、泛型方法。
* 1.关于自定义泛型类。泛型接口：
*
*
* */
public class GenericTest1 {
    @Test
    public void test1(){
        //如果定义了泛型类，实例化没有指明类的泛型，则认为此泛型类型为Object类型
        //要求：如果定义的类是带泛型的，建议在实例化时要指明类的泛型
        Order order=new Order();
        order.setOrderT(123);
        order.setOrderT("ABC");
        //建议:实例化时指明类的泛型
        Order<String> order1=new Order<>("order1","1001","abc");
        order1.setOrderT("ABC");
//        order1.setOrderT(123);
    }
    @Test
    public void test2(){
        SubOrder subOrder1=new SubOrder();
        //由于子类在继承带泛型的父类时，指明了泛型类型。则实例化子类对象时，不再需要指明泛型类型。
        subOrder1.setOrderT(11232);

        SubOrder1<String> subOrder2=new SubOrder1<>();
        subOrder2.setOrderT("123123");
    }

    @Test
    public void test3(){
        //泛型不同的引用不能相互赋值
        ArrayList<String> list1 = null;
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        //泛型不同的引用不能相互赋值。
//        list1 = list2;

        Object p1 = null;
        Object p2 = null;
        p1 = p2;

    }

    @Test
    public void test4(){
        Order<String> order=new Order<>();
        Integer[] arr=new Integer[]{1,2,3,4};
        //泛型方法在调用时，指明泛型参数的类型，与类的泛型没有任何关系
        List<Integer> list=order.copyFromArrayToList(arr);
        System.out.println(list);
    }
}
