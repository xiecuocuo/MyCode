package com.atguigu.spring.geneeric.di;

import org.springframework.beans.factory.annotation.Autowired;

public class BaseSerivce<T> {
    @Autowired
    protected BaseRepository<T> repository;

    public void add(){
        System.out.println("add...");
        System.out.println(repository);
    }
}
