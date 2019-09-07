package InterView;

/**
 * Created by ld_ab on 2019/9/7.
 * 用于查找字符串内重复字母最小下标
 * 主要考察indexOf和charAt的用法
 */
public class FindRepeatStr {
    public static void main(String[] args) {
        String str = "qzcsabab";
        int res=FindRepeatStr(str);
        if(res>=0){
            System.out.println("The Repeat Number's sub is:"+res);
        }else{
            System.out.println("No repeat Numbers!");
        }
    }
    public static int FindRepeatStr(String str) {
        int p=-1;
        for (int i = 0; i < str.length(); i++) {
            if(str.indexOf(str.charAt(i),i+1)!=-1){
                p=i;
                break;
            }
    }
        return p;
    }
}