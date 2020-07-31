package com.springshizhan4.package4;

import com.springshizhan4.package3.Dessert;
import com.springshizhan4.package3.IceCream;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Configuration
@ComponentScan
public class JavaConfig {
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public NotePad notePad(){
        return new NotePad();
    }
    @Bean
    @Scope(value = WebApplicationContext.SCOPE_SESSION,proxyMode = ScopedProxyMode.INTERFACES)
    public ShoppingCart cart(){
        return null;
    }
}
