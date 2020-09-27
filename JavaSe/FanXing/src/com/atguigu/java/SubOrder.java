package com.atguigu.java;

import java.util.ArrayList;
import java.util.List;

public class SubOrder extends Order<Integer> {//不在是泛型类
    //泛型方法：在方法中出现了泛型的结构，泛型参数与类的泛型参数没有任何关系。
    //泛型方法所属的类型与泛型类没有关系
    public <E> List<E> copyFromArraysToList(E[] arr){
        ArrayList<E> arrayList=new ArrayList<E>();
        for(E e:arr){
            arrayList.add(e);
        }
        return arrayList;
    }
}
