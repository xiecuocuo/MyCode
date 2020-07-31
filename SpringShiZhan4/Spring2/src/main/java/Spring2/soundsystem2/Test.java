package Spring2.soundsystem2;

import Spring2.soundsystem.CompactDisc;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        CompactDisc  compactDisc= (CompactDisc) ctx.getBean("reallyBlankDisc");
        compactDisc.play();
    }
}
