package com.aiguigu.spring.aop.helloworld;

public class Main {
    public static void main(String[] args) {
        //1.原始效果
        ArithmeticCaculatorImpl arithmeticCaculator=new ArithmeticCaculatorImpl();
        arithmeticCaculator.add(1,40);
        //2.代理模型效果
        ArithmeticCaculator caculator=new ArithmeticCaculatorImplLoggingProxy(arithmeticCaculator).getLoggingProxy();
        caculator.add(1,40);
    }
}
