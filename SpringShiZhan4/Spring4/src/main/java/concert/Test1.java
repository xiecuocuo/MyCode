package concert;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
    @Test
    public void test1(){
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(JavaConfig1.class);
        Proformance proformance1= (Proformance) applicationContext.getBean("proformer");
        proformance1.proform();
    }
    @Test
    public void test2(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("application.xml");
        Proformance proformance1= (Proformance) applicationContext.getBean("proformer");
        proformance1.proform();
    }
    @Test
    public void test3(){
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(JavaConfig1.class);
        CompactDisc compactDisc= (CompactDisc) applicationContext.getBean("compactDisc");
        compactDisc.playTrack(12);
        compactDisc.playTrack(12);
        compactDisc.playTrack(12);
        compactDisc.playTrack(12);
        compactDisc.playTrack(12);
    }
}
