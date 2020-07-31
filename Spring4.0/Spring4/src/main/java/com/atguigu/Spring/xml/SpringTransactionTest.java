package com.atguigu.Spring.xml;

import com.atguigu.Spring.xml.service.BookShopService;
import com.atguigu.Spring.xml.service.Cashier;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class SpringTransactionTest {
    private ApplicationContext ctx=null;
    private BookShopDao bookShopDao=null;
    private BookShopService bookShopService;
    private Cashier cashier;
    {
        ctx=new ClassPathXmlApplicationContext("applicationContext-xml.xml");
        bookShopDao= (BookShopDao) ctx.getBean("bookShopDao");
        bookShopService=(BookShopService) ctx.getBean("bookShopService");
        cashier=(Cashier) ctx.getBean("cashier");
    }

    @Test
    public void testFindBookPriceByIsbn(){
        System.out.println(bookShopDao.findBookPriceByIsbn("1001"));
    }

    @Test
    public void testUpdateBookStock(){
        bookShopDao.updateBookStock("1001");
    }

    @Test
    public void testUpdateUserAccount(){
        bookShopDao.updateUserAccount("AAA",10);
    }

    @Test
    public void testPurchase(){
        //第一次买正常，第二次买库存减了，钱没减少
        bookShopService.purchase("AAA","1001");
    }
    @Test
    public void testTransactionPropagation(){
        cashier.checkout("AAA", Arrays.asList("1001","1002"));
    }
}
