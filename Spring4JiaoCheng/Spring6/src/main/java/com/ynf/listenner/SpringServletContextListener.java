package com.ynf.listenner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class SpringServletContextListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //1. 获取 Spring 配置文件的名称.
        ServletContext servletContext=servletContextEvent.getServletContext();
        String configLoc=servletContext.getInitParameter("contextConfigLocation");
        //2. 创建 IOC 容器
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(configLoc);
        //3. 把 IOC 容器放在 ServletContext 的一个属性中.
        servletContext.setAttribute("ApplicationContext",applicationContext);
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
