package Spring5.hibernate.service.impl;

import Spring5.hibernate.service.BookShopService;
import Spring5.hibernate.service.CashierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CashierServiceImpl implements CashierService {
    @Autowired
    private BookShopService bookShopService;
    @Override
    public void checkout(String username, List<String> isbns) {
        for(String isbn:isbns){
            bookShopService.purchase(username, isbn);
        }
    }
}
