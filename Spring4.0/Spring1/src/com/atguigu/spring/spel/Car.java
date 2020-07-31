package com.atguigu.spring.spel;

public class Car {
    private String brand;
    private double price;
    private double tyrePrerimeter;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTyrePrerimeter() {
        return tyrePrerimeter;
    }

    public void setTyrePrerimeter(double tyrePrerimeter) {
        this.tyrePrerimeter = tyrePrerimeter;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", tyrePrerimeter=" + tyrePrerimeter +
                '}';
    }
}
