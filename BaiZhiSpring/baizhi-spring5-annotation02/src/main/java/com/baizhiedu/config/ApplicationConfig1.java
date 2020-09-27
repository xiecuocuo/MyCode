package com.baizhiedu.config;

import com.baizhiedu.dao.UserDAO;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Service;


@Configuration
@ComponentScan(basePackages = {"com.baizhiedu"},useDefaultFilters = false,includeFilters = {
        @ComponentScan.Filter(type =FilterType.ANNOTATION,value ={Service.class}),
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,value = {UserDAO.class})
})
public class ApplicationConfig1 {
}
