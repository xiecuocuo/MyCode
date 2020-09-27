package com.atguigu.java2;

import org.junit.Test;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
* 1.泛型在继承方面的体现：
*
* 2.通配符的使用
* */
public class GenericTest {
    /*
    1.泛型在继承方面的体现：
    虽然类A是类B的父类，但是G<A> 和G<B>二者不具备子父类关系，二者是并列关系。
    补充：类A是类B的父类，A<G> 是 B<G> 的父类
    * */
    @Test
    public void test1(){
        Object obj=null;
        String str=null;

        obj=str;

        Object[] arr1=null;
        String[] arr2=null;
        arr1=arr2;

        List<Object> list1 = null;
        List<String> list2 = new ArrayList<String>();
        //此时的list1和list2不具有子父类关系
//        list1=list2;
        /*
        反证法：
        假设list1 = list2;
           list1.add(123);导致混入非String的数据。出错。
         */
        show1(list1);
        show1(list2);
        show(list1);
//        show(list2);编译不通过

    }

    //通用性较较好
    public <E> void show1(List<E> list){

    }
    //通用性较差
    public void show(List<Object> list){

    }

    //接口与实现类之间也可以实现互通
    @Test
    public void test2(){

        AbstractList<String> list1 = null;
        List<String> list2 = null;
        ArrayList<String> list3 = null;

        list1 = list3;
        list2 = list3;

        List<String> list4 = new ArrayList<>();

    }

    /*
    * 通配符的使用：
    * 通配符?
    * 类A是类B的父类，G<A>和G<B>是没有关系的，二者共同的父类是：G<?>
    * */
    @Test
    public void test3(){
        List<Object> list1=null;
        List<String> list2=null;

        List<?> list=null;
        list=list1;
        list=list2;

        print(list1);
        print(list2);

        List<String> list3 = new ArrayList<>();
        list3.add("AA");
        list3.add("BB");
        list3.add("CC");
        list = list3;
        //添加(写入)：对于List<?>就不能向其内部添加数据。
        //除了添加null之外。
        list.add(null);
        //获取(读取)：允许读取数据，读取的数据类型为Object。
        Object o = list.get(0);
        System.out.println(o);
    }

    public void print(List<?> list){
        Iterator<?> iterator=list.iterator();
        while(iterator.hasNext()){
            Object obj=iterator.next();
            System.out.println(obj);
        }
    }

    /*
    * 3.有限制条件的通配符的使用：
    * ? extends Person:
    *   G<? extends A> 可以作为G<A>和G<B>的父类，其中B是A的子类
    * ? super Person：
    *   G<? super A> 可以作为G<A>和G<B>的父类，其中B是A的父类
    *
    * */
    @Test
    public void test4(){
        List<? extends Person> list1=null;
        List<? super Person> list2=null;

        List<Student> list3 = new ArrayList<Student>();
        List<Person> list4 = new ArrayList<Person>();
        List<Object> list5 = new ArrayList<Object>();

        list1=list3;
        list1=list4;
//        list1=list5;

//        list2=list3;
        list2=list4;
        list2=list5;

        //读取数据：
        list1 = list3;
        Person p = list1.get(0);
        //编译不通过
        //Student s = list1.get(0);

        list2=list4;
        Object obj=list2.get(0);

        //写入数据(只要是比泛型中小的类型都能装到集合中)
//        list1.add(new Person());//如果泛型类是Person的子类呢。加载就报错了。
        list2.add(new Person());
        list2.add(new Student());
    }
}
