package com.atguigu.config;

import com.atguigu.bean.RainBow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    /*
    AnnotationMetadata：当前类的注解信息
    BeanDefinitionRegistry:BeanDefinition注册类；把所有需要添加到容器中的bean；调用BeanDefinitionRegistry.registerBeanDefinition手工注册进来
    * */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        boolean flag1=beanDefinitionRegistry.containsBeanDefinition("com.atguigu.bean.Blue");
        boolean flag2=beanDefinitionRegistry.containsBeanDefinition("com.atguigu.bean.Red");
        if(flag1&&flag2){
            //指定Bean定义信息；（Bean的类型，Bean。。。）
            RootBeanDefinition rootBeanDefinition=new RootBeanDefinition(RainBow.class);
            beanDefinitionRegistry.registerBeanDefinition("rainbow",rootBeanDefinition);
        }
    }
}
