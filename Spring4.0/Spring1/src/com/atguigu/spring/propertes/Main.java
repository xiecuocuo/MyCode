package com.atguigu.spring.propertes;

import com.mchange.v2.c3p0.jboss.C3P0PooledDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        ApplicationContext ctx=new ClassPathXmlApplicationContext("bean-property.xml");
        C3P0PooledDataSource ds= (C3P0PooledDataSource) ctx.getBean("dataSource");
        System.out.println(ds);
    }
}
