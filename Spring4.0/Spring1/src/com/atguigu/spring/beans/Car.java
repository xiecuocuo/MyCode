package com.atguigu.spring.beans;

import java.util.Objects;

public class Car {
    private String pinpai;
    private String name;
    private double maxSpeed;

    public Car() {
    }

    public Car(String pinpai, String name, double maxSpeed) {
        this.pinpai = pinpai;
        this.name = name;
        this.maxSpeed = maxSpeed;
    }

    public String getPinpai() {
        return pinpai;
    }

    public void setPinpai(String pinpai) {
        this.pinpai = pinpai;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
    @Override
    public String toString() {
        return "Car{" +
                "pinpai='" + pinpai + '\'' +
                ", name='" + name + '\'' +
                ", maxSpeed=" + maxSpeed +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return Double.compare(car.maxSpeed, maxSpeed) == 0 &&
                pinpai.equals(car.pinpai) &&
                name.equals(car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pinpai, name, maxSpeed);
    }
}
