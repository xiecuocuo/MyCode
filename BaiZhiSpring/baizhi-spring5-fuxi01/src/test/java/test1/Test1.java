package test1;

import com.baizhiedu.bean.User;
import com.baizhiedu.service.UserSerivce;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test1 {
    @Test
    public void test1(){
        ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserSerivce userService= (UserSerivce) applicationContext.getBean("userService");
        User user=new User();
        user.setUsername("123");
        user.setPassword("45666");
        userService.register(user);
    }
}
