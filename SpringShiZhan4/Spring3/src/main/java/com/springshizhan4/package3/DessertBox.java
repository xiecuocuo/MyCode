package com.springshizhan4.package3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class DessertBox {
    private Dessert dessert;
    @Autowired
    @Cold
    @Fruity
    public void setDessert(Dessert dessert) {
        this.dessert = dessert;
    }
    public void info(){
        dessert.detail();
    }
}
