package com.atguigu.Spring.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService {

    @Autowired
    private BookShopDao bookShopDao;
    /*
     * 添加事务注解：
     * 1.使用propagation指定事务的传播行为，即当前的事务方法被另外一个事务方法调用时，如何使用事务？
     *  默认情况下取值为REQUIRED,即使用调用方法的当前事务。
     *  REQUIRES_NEW:新开一个自己的事务，当前事务被挂起
     * 2.使用isolation指定事务的隔离级别，最常用的取值为READ_COMMITTED
     * 3.默认情况下Spring对所有的声明式事务进行回滚，也可以通过对应的属性进行设置(通常情况下，默认值即可)
     * 4.使用readonly:指定事务是否为只读。表示这个事务读取数据但不更新数据，这样可以帮助数据库引擎进行优化事务，若真的是一个只读取数据库值的方法，
     * 应设置readonly=true
     * 5.使用timeout指定强制回滚之前事务可以占用的时间
     * */
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED,
            noRollbackFor = {UserAccountException.class},readOnly = false,timeout = 3)
    @Override
    public void purchase(String username,String isbn) {
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        //1.获取书的单价
        double price=bookShopDao.findBookPriceByIsbn(isbn);
        //2.更新书的库存
        bookShopDao.updateBookStock(isbn);
        //3.更新用户的余额
        bookShopDao.updateUserAccount(username,price);
    }
}
