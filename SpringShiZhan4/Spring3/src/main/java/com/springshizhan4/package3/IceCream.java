package com.springshizhan4.package3;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Cold
@Creamy
public class IceCream implements Dessert {
    @Override
    public void detail() {
        System.out.println("This is an IceCream");
    }
}
