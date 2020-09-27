package com.atguigu.config;

import com.atguigu.aop.LogAspects;
import com.atguigu.aop.MathCaculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@Configuration
public class MainConfigAop {
    @Bean
    public LogAspects logAspects(){
        return new LogAspects();
    }
    @Bean
    public MathCaculator mathCaculator(){
        return new MathCaculator();
    }
}
