package com.atguigu.config;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class LinuxCondition implements Condition {

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        // TODO是否linux系统
        //1、能获取到ioc使用的beanfactory
        BeanFactory beanFactory=conditionContext.getBeanFactory();
        //2.获取类加载器
        ClassLoader classLoader=conditionContext.getClassLoader();
        //3.获取当前环境变量
        Environment environment=conditionContext.getEnvironment();
        //4.获取Bean定义的注册类
        BeanDefinitionRegistry registry = conditionContext.getRegistry();
        String property = environment.getProperty("os.name");
        //可以判断容器中的bean注册情况，也可以给容器中注册bean
        boolean definition = registry.containsBeanDefinition("person");
        if(property.contains("linux")){
            return true;
        }
        return false;
    }
}
