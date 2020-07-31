package Spring2.soundsystem;

import Spring2.soundsystem2.CdPlayer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        Spring2.soundsystem2.CdPlayer  cdPlayer= (CdPlayer ) ctx.getBean("cdPlayer2");
        cdPlayer.play();
    }
}
