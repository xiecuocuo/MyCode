package test1;

import java.util.HashMap;

public class TestHashMap {
    public static void main(String[] args) {
        HashMap<String,String> map=new HashMap();
        map.put("1","2");
        String oldValue=map.put("1","3");//2
        System.out.println(oldValue);

        System.out.println(Integer.highestOneBit(15));//8
        System.out.println(Integer.highestOneBit(16));//16
        System.out.println(Integer.highestOneBit(17));//16
    }
}
