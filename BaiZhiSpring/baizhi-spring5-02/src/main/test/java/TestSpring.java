import com.baizhiedu.aspect.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
/*    @Test
    public void test1(){
        ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext1.xml");
        UserService userService1= (UserService) applicationContext.getBean("userService1");
        userService1.login("ynf","123");
        userService1.register("ynf","123");
        OrderService orderService= (OrderService) applicationContext.getBean("orderService1");
        orderService.login("ynf","123");
        orderService.register("ynf","123");
    }*/
/*    @Test
    public void test2(){
        ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext2.xml");
        UserService userService1= (UserService) applicationContext.getBean("userService");
        userService1.login("ynf","123");
        userService1.register("ynf","123");
    }*/
    @Test
    public void test3(){
        ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext3.xml");
        UserService userService1= (UserService) applicationContext.getBean("userService");
        userService1.register("ynf","123");
    }
}
