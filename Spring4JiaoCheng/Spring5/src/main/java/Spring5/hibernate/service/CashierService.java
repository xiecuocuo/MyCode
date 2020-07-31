package Spring5.hibernate.service;

import java.util.*;

public interface CashierService {
    public void checkout(String username, List<String> isbns);
}
