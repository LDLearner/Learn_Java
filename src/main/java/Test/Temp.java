package Test;

/**
 * Created by LD on 2019/3/29.
 */
@org.testng.annotations.Test
public class Temp {
        public static void index(String str) {
            int p=-1;
            for (int i = 0; i < str.length(); i++)
            { if(str.indexOf(str.charAt(i),i+1)!=-1){
                p=i;
                break; } }
            System.out.println(p); }
    public static void main(String[] args) {
        String str="1ubcdefab";
        index(str); }
    }
