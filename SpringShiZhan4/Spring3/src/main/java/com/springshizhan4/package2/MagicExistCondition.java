package com.springshizhan4.package2;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class MagicExistCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata data) {
        Environment environment=context.getEnvironment();
//        return environment.containsProperty("magic");//检查magic属性是存在
        return false;
    }
}
