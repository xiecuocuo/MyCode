package com.springshizhan4.package4;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
//@Scope("prototype")
public class NotePad {
}
