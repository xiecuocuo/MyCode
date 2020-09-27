package xmlaop;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
    @Test
    public void test1(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationAop.xml");
        Proformance proformance1= (Proformance) applicationContext.getBean("proformer");
        proformance1.proform();
    }
    @Test
    public void test2(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationAop2.xml");
        CompactDisc compactDisc= (CompactDisc) applicationContext.getBean("compactDisc");
        compactDisc.playTrack(12);
        compactDisc.playTrack(12);
        compactDisc.playTrack(12);
        compactDisc.playTrack(12);
        compactDisc.playTrack(12);
    }
    @Test
    public void test3(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationAop3.xml");
        Person student= (Person) applicationContext.getBean("student");
        Skill skill = (Skill)student; // 通过类型转换，student对象就拥有了SkillImp 类的方法
        skill.getSkill("我会英语");
        student.sayIdentification();
    }
}
