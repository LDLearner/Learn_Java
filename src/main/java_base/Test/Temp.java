package Test;

/**
 * Created by LD on 2019/3/29.
 */
public class Temp {
    public static void main(String[] args) {
        //long a=1577289600000;
        long days=(int)((1577289600000L-1551888000000L) / (3600 * 24*1000) + 1);
        System.out.print("diffDay=" + days);
    }
}
