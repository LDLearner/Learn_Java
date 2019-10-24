package Math;

/**
 * Created by ld_ab on 2019/9/5.
 */
public class Quicksort {
    public static void main(String[] args) {
        shuffle arr=new shuffle();
        int[] a=arr.ShuffleArray(5);
        arr.readArray(a);
        quicksort(a,0,a.length-1);
        System.out.println("---------------------------------------------------------------------");
        arr.readArray(a);
    }
    static void quicksort(int[] a,int start,int end){
        int mid=start,last=0;start++;
            while (a[mid] > a[start]&&end>start) {
                if (start< end) {
                    start++;
                } else {
                    int temp = 0;
                    temp = a[mid];
                    a[mid] = a[start];
                    a[start] = temp;
                    System.out.println("xiao");
                    break;
                }
                while (a[mid] < a[end]) {
                    if (end > mid) {
                        end--;
                    } else {
                        int temp = 0;
                        temp = a[mid];
                        a[mid] = a[end];
                        a[end] = temp;
                        System.out.println("da");
                        break;
                    }

                }

            }
        //System.out.println("a[start]="+start);
       // System.out.println("a[end]="+end);

            //quicksort(a, start, last);
           // quicksort(a, last, end);
        }
}
