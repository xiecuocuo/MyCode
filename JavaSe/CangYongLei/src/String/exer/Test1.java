package String.exer;

import org.junit.Test;

public class Test1 {
    /*4.获取两个字符串中最大相同子串。比如：
        str1 = "abcwerthelloyuiodef“;str2 = "cvhellobnm"
        提示：将短的那个串进行长度依次递减的子串与较长的串比较。
    第4题： 如果只存在一个最大长度的相同子串
    * */
    public String getMaxSameSubString(String str1,String str2){
        String maxStr =str1;
        String minStr=str2;
        if(maxStr.length()<minStr.length()){
            maxStr=str2;
            minStr=str1;
        }
        int len=minStr.length();
        for(int i=0;i<len;i++){
            for(int x=0,y=len-i;y<=len;x++,y++){
                if(maxStr.contains(minStr.substring(x,y))){
                    return minStr.substring(x,y);
                }
            }
        }
        return null;
    }
    @Test
    public void test5(){
        System.out.println(getMaxSameSubString("abcwerthelloyuiodef","cvhellobnm"));
    }
}

