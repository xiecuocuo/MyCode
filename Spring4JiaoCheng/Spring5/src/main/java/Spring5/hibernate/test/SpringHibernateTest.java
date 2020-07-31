package Spring5.hibernate.test;

import Spring5.hibernate.service.BookShopService;
import Spring5.hibernate.service.CashierService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.util.Arrays;

public class SpringHibernateTest {
    private ApplicationContext context=null;
    {
        context=new ClassPathXmlApplicationContext("applicationContext.xml");

    }
    @Test
    public void test1(){
        DataSource dataSource= (DataSource) context.getBean("dataSource");
        System.out.println(dataSource);
    }
    @Test
    public void testCashier(){
        CashierService cashierService= (CashierService) context.getBean("cashierServiceImpl");
        cashierService.checkout("AAA", Arrays.asList("1001","1002"));
    }

    @Test
    public void testBookShopService(){
        BookShopService bookShopService= (BookShopService) context.getBean("bookShopServiceImpl");
        bookShopService.purchase("AAA", "1001");
    }
}
