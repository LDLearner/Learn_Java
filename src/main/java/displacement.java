/**
 * Created by LD on 2017/12/5.
 *
 */
public class displacement {
    public static void main(String[] args){
        long l = 1234567890123456l;
        for (int i = 63; i >= 0; i--) {
            System.out.print((l & (1l << i)) != 0 ? 1 + " " : 0 + " ");
            if (i % 8 == 0)
                System.out.println();
        }
        System.out.println();
        int j = (int) l;
        System.out.println(j);
        for (int i = 31; i >= 0; i--) {
            System.out.print((j & (1l << i)) != 0 ? 1 + " " : 0 + " ");
            if (i % 8 == 0)
                System.out.println();
        }

    }

}
