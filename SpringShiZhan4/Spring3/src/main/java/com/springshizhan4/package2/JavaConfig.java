package com.springshizhan4.package2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;

public class JavaConfig {
    @Bean
    @Conditional(MagicExistCondition.class)
    public MagicBean magicBean(){
        return new MagicBean();
    }
}
