package com.atguigu.config;

import com.atguigu.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*
* bean的生命周期：
*   Bean创建----初始化----销毁过程
*
* 容器管理bean的生命周期：
* 我们可以自动以初始化和销毁方法，容器在bean进行到当前生命周期的时候来调用我们自定义的初始化和销毁方法
*   BeanPostProcessor.postProcessBeforeInitialization
* 构造（对象创建）
*   单实例：在容器启动的时候创建对象
* 	多实例：在每次获取的时候创建对象
*   BeanPostProcessor.postProcessAfterInitialization
* 销毁：
*   单实例：容器关闭的时候
*   多实例：容器不会管理这个bean；容器不会调用销毁方法；（需要手动去调用它的销毁方法）
*
* 1）、指定初始化和销毁方法。指定initMethod和destoryMethod
* 2）、通过让Bean实现InitializingBean（定义初始化逻辑），DisposableBean（定义销毁逻辑）;
* 3）、可以使用JSR250规范里的两个注解：
*   @PostConstructor:在bean创建完成并且属性赋值完成；来执行初始化方法
*   @PreDestroy:在容器销毁bean之前通知我们进行清理工作
* 4)、@BeanPostProcessor:Bean的后置处理器；在Bean初始化前后进行一些处理工作
*       postProcessBeforeInitialization:在初始化之前工作
*       postProcessAfterInitialization:在初始化之后工作
*
* BeanPostProcessor原理
* populateBean(beanName, mbd, instanceWrapper);给bean进行属性赋值(构造器赋值，get,set方法赋值)
* initializeBean
* {
*   applyBeanPostProcessorsBeforeInitialization(wrappedBean, beanName);
*   invokeInitMethods(beanName, wrappedBean, mbd);执行自定义初始化
*   applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName);
*}
* */
@Configuration
@ComponentScan("com.atguigu.bean")
public class MainConifgLifeCycle {
    @Bean(initMethod = "init",destroyMethod = "destory")
    public Car car(){
        return new Car();
    }
}
