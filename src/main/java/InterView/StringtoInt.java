package InterView;

/**
 * Created by ld_ab on 2019/9/7.
 * 本题考察substring和Integer.parseInt等api的用法
 */
public class StringtoInt {
    public static void main(String[] args) {
        String str="12345";
        int[] res=StringtoInt(str);
        for(int i=0;i<str.length();i++){
            System.out.println(res[i]);
        }
    }
    static int[] StringtoInt(String str){
        int[] intarr=new int[str.length()];
        for(int i=0;i<str.length();i++){
            intarr[i]=Integer.parseInt(str.substring(i,i+1));
        }
        System.out.println("----------------------------------------");
        return intarr;
    }


}
