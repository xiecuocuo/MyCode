package test;

import com.baizhiedu.yml.ApplicationConfigYml;
import com.baizhiedu.yml.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test2 {
    @Test
    public void test1(){
        ApplicationContext ctx=new AnnotationConfigApplicationContext(ApplicationConfigYml.class);
        User user= (User) ctx.getBean("user");
        System.out.println(user);
    }
}
