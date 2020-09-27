package com.baizhiedu.basic;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BeanFactory {
    private static Properties env=new Properties();
    static {
        InputStream inputStream=null;
        try {
            //1.获取IO输入流
            inputStream=BeanFactory.class.getResourceAsStream("/applicationContext.properties");
            //2.文件内容 封装Properties集合
            env.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /*public static UserService getUserService(){
        UserService userService=null;
        try {
            Class clazz=Class.forName(env.getProperty("userService"));
            userService= (UserService) clazz.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return userService;
    }

    public static UserDAO getUserDAO(){
        UserDAO userDAO=null;
        try {
            Class clazz=Class.forName(env.getProperty("userDao"));
            userDAO= (UserDAO) clazz.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return userDAO;
    }*/
    /*
    key:小配置文件中的key(可以是UserDao,也可以是UserService)
    * */
    public static Object getBean(String key){
        Object ret=null;
        Class clazz= null;
        try {
            clazz = Class.forName(env.getProperty(key));
            ret=clazz.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return ret;
    }
}
