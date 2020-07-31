package com.springshizhan4.package3;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Cold
@Fruity
public class Popsicle implements Dessert {
    @Override
    public void detail() {
        System.out.println("This is an Popsicle");
    }
}
