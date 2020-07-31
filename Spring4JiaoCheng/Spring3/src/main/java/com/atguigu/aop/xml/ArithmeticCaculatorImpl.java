package com.atguigu.aop.xml;

import com.atguigu.aop.impl.ArithmeticCaculator;
import org.springframework.stereotype.Component;

public class ArithmeticCaculatorImpl implements ArithmeticCaculator {
    @Override
    public int add(int i, int j) {
        int result=i+j;
        return result;
    }

    @Override
    public int sub(int i, int j) {
        int result=i-j;
        return result;
    }

    @Override
    public int mul(int i, int j) {
        int result=i*j;
        return result;
    }

    @Override
    public int div(int i, int j) {
        int result=i/j;
        return result;
    }
}
