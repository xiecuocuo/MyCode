package com.atguigu.spring.annotation.reponsitory;

import org.springframework.stereotype.Repository;

@Repository
public class JdbcResponsitory implements UserResponsitory {
    @Override
    public void save() {
        System.out.println("JdbcResponsitory save ...");
    }
}
