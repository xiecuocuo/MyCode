package com.baizhiedu;

import com.baizhidu.basic.*;
import com.baizhidu.beanpostprocessor.Category;
import com.baizhidu.constructor.Customer;
import com.baizhidu.factorybean.ConnectionFactoryBean;
import com.baizhidu.life.Product;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.util.Arrays;

public class TestSpring {
    /*
    用于测试工厂类进行耦合的操作
    * */
    @Test
    public void test1(){
        //UserServiceImplNew
        //UserService userService=new UserServiceImplNew();
//        UserService userService=new UserServiceImpl();
        UserService userService= (UserService) BeanFactory.getBean("userService");//解决了调用部分的耦合
        userService.login("ynf","123");

        User user=new User("1","ynf","123");
        userService.register(user);
    }
    @Test
    public void test2(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person= (Person) applicationContext.getBean("person");
        System.out.println(person);
    }

    @Test
    public void test3(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        /*
        * getBean方法的重载方法：
        * getBean(String str)
        * getBean(String str,Class class)
        * getBean(Class class)
        * */
        Person person=applicationContext.getBean("person",Person.class);//通过这种方式获取Bean不需要强制类型转换
        person=applicationContext.getBean(Person.class);

        //获取Spring工厂所有Bean标签的id值
        String[] beanNames1=applicationContext.getBeanDefinitionNames();
        System.out.println(Arrays.toString(beanNames1));

        //通过类型获取Spring配置文件中，对应的id的值
        String[] beanNames2=applicationContext.getBeanNamesForType(Person.class);
        System.out.println(beanNames2);

        //用于判断是否存在对应id值的bean
        boolean flag=applicationContext.containsBeanDefinition("person");
        System.out.println(flag);

        //用于判断是否存在对应id值的bean
        boolean flag1=applicationContext.containsBean("person");
        /*
        * containsBean和containsBeanDefinition是有区别的：
        * containsBean可以判断id，也可以判断name
        * containsBeanDefinitions只能判断id
        * */
    }
    @Test
    public void test4(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person= (Person) applicationContext.getBean(Person.class);
        String[] beanNames1=applicationContext.getBeanDefinitionNames();
        System.out.println(Arrays.toString(beanNames1));//[com.baizhidu.basic.Person#0]
    }

    @Test
    public void test5(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person= (Person) applicationContext.getBean(Person.class);
        System.out.println(person);
    }
    @Test
    public void test6(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserServiceImpl userService= (UserServiceImpl) applicationContext.getBean("userService");
        System.out.println(userService.getUserDAO());
    }
    @Test
    public void test7(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        Customer customer= (Customer) applicationContext.getBean("customer");
        System.out.println(customer);
    }
    @Test
    public void test8(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        Connection connection= (Connection) applicationContext.getBean("conn");
        System.out.println(connection);
    }
    @Test
    public void test9(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        ConnectionFactoryBean connectionFactoryBean= (ConnectionFactoryBean) applicationContext.getBean("&conn");
        System.out.println(connectionFactoryBean);//com.baizhidu.factorybean.ConnectionFactoryBean@6b1274d2
    }
    @Test
    public void test10(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        Connection connection1= (Connection) applicationContext.getBean("conn");
        Connection connection2= (Connection) applicationContext.getBean("conn");
        System.out.println(connection1==connection2);
    }

    @Test
    public void test11(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        Connection connection= (Connection) applicationContext.getBean("conn1");
        System.out.println(connection);
    }

    @Test
    public void test12(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        Connection connection= (Connection) applicationContext.getBean("conn2");
        System.out.println(connection);
    }

    @Test
    public void test13(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
//        Product product = (Product) applicationContext.getBean("product");
    }
    @Test
    public void test14(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        Product product = (Product) applicationContext.getBean("product");
    }
    @Test
    public void test15(){
        ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        Product product = (Product) applicationContext.getBean("product");
        applicationContext.close();
    }
    @Test
    public void test16(){
        ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext1.xml");
        Connection connection= (Connection) applicationContext.getBean("conn");
        System.out.println(connection);
    }

    @Test
    public void test17(){
        ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext2.xml");
        com.baizhidu.converter.Person  person= (com.baizhidu.converter.Person ) applicationContext.getBean("person");
        System.out.println(person);
    }
    @Test
    public void test18(){
        ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext3.xml");
        Category category= (Category) applicationContext.getBean("category");
        System.out.println(category);
    }
    @Test
    public void test19(){
        ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext4.xml");
        com.baizhidu.proxy.UserService userService= (com.baizhidu.proxy.UserService) applicationContext.getBean("userService");
        userService.login("ynf","123");
    }
}
