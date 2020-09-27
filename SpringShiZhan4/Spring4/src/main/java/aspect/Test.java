package aspect;

import concert.Proformance;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    @org.junit.Test
    public void test1(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationAspect.xml");
        Proformance proformance1= (Proformance) applicationContext.getBean("proformer");
        proformance1.proform();
    }
}
