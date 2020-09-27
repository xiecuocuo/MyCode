package com.baizhiedu.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    Logger logger= LoggerFactory.getLogger(Test.class);
    @org.junit.Test
    public void test1(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        logger.info(context.getBean("userDao").toString());
    }
}
