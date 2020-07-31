package com.springshizhan4.package3;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class Cookie implements Dessert {
    @Override
    public void detail() {
        System.out.println("this is a Cookie");
    }
}
