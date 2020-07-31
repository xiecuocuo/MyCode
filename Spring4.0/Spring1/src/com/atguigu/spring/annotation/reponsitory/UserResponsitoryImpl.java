package com.atguigu.spring.annotation.reponsitory;

import org.springframework.stereotype.Repository;
//方式2：在属性或者set方法中使用@Qualifier注解指定装配的bean
@Repository
public class UserResponsitoryImpl implements UserResponsitory {
    @Override
    public void save() {
        System.out.println("UserResponsitory Save......");
    }
}
