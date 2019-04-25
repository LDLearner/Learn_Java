package Test;

/**
 * Created by LD on 2019/3/29.
 */
public class Temp {
    public static void main(String[] args) {
        readArray(createArray(100));
    }
    static int[] createArray(int n){
        int[] a=new int[n];
        for (int i=0;i<n;i++){
            a[i]=i;
        }
        return a;
    }
    static void readArray(int[] array){
        for (int i=0;i<array.length;i++){
            System.out.println("Arr["+i+"]="+array[i]);
        }
    }
}
