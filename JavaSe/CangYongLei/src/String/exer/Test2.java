package String.exer;


import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Test2 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        byte[] bytes1={-26, -78, -77, -27, -115};
        String str1=new String(bytes1,"UTF-8");
        System.out.println(str1);
        byte[] bytes2={-105,-27,-69, -70, -28, -72, -102, -26, -100, -119, -23, -103, -112, -27, -123, -84, -27, -113, -72};
        String str2=new String(bytes2,"UTF-8");
        System.out.println(str2);
        System.out.println(Arrays.toString(str1.getBytes()));
        System.out.println(Arrays.toString(str2.getBytes()));
        System.out.println(str1.concat(str2));
    }
}
