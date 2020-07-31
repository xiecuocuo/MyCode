package Spring2.package5;

import Spring2.soundsystem.CompactDisc;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
/*    public static void main(String[] args) {
        ApplicationContext ctx=new AnnotationConfigApplicationContext(SoundSystemConfig.class);
        //取XML文件中的配置Bean
        CompactDisc  compactDisc= (CompactDisc) ctx.getBean("compactDisc1");
        compactDisc.play();
        //取JavaConfig中的配置Bean
        Spring2.package5.CompactDisc  compactDisc2= (Spring2.package5.CompactDisc) ctx.getBean("getCompactDisc");
        compactDisc2.play();
    }*/
    public static void main(String[] args) {
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext2.xml");
        CDPlayer cdPlayer= (CDPlayer) ctx.getBean("cdPlayer");
        cdPlayer.play();
    }
}
