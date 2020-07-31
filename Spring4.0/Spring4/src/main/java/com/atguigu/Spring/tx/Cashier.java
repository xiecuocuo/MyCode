package com.atguigu.Spring.tx;

import java.util.*;

public interface Cashier {
    public void checkout(String username, List<String> isbns);
}
