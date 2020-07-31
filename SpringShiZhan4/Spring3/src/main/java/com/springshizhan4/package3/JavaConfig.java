package com.springshizhan4.package3;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan
public class JavaConfig {
    @Bean
    @Qualifier("cold")
    public Dessert iceCream(){
        return new IceCream();
    }
}
