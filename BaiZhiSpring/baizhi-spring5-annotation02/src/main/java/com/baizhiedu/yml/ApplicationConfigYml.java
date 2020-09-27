package com.baizhiedu.yml;

import javafx.beans.property.Property;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

import java.util.Properties;

@Configuration
@ComponentScan(basePackages = {"com.baizhiedu.yml"})
public class ApplicationConfigYml {
    @Bean
    public PropertySourcesPlaceholderConfigurer configurer(){
        YamlPropertiesFactoryBean yamlPropertiesFactoryBean=new YamlPropertiesFactoryBean();
        yamlPropertiesFactoryBean.setResources(new ClassPathResource("userinit.yml"));
        Properties properties=yamlPropertiesFactoryBean.getObject();

        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer=new PropertySourcesPlaceholderConfigurer();
        propertySourcesPlaceholderConfigurer.setProperties(properties);
        return propertySourcesPlaceholderConfigurer;
    }
}
