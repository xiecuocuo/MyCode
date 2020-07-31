package com.atguigu.filter;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

public class MyTypeFilter implements TypeFilter {
    /*
    * metadataReader:读取到的当前正在扫描的类信息
    * metadataFactory:可以获取到的任何类的信息
    * */
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        //获取当前类注解的信息
        AnnotationMetadata annotationMetadata=metadataReader.getAnnotationMetadata();
        //获取当前类的类信息
        ClassMetadata classMetadata=metadataReader.getClassMetadata();
        //获取类名
        String className=classMetadata.getClassName();
        //获取类路径
        Resource resource=metadataReader.getResource();
        System.out.println("--->"+className);
        System.out.println(resource.getURI());
        if(className.contains("er")){
            return true;
        }
        return false;
    }
}
