package com.atguigu.Spring.tx;

public interface BookShopDao {
    //根据书号获取输的单价
    public double findBookPriceByIsbn(String isbn);
    //更新书的库存，使书号对应的库存减1
    public void updateBookStock(String isbn);
    //更新用户的账户余额：使username的balance-price
    public void updateUserAccount(String username,double price);
}
