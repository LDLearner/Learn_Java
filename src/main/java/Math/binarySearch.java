package Math;

/**
 * Created by LD on 2019/4/25.
 * 二分法查找，必须是有序数组
 */
public class binarySearch {
    public static void main(String[] args) {
        binarySearch b=new binarySearch();
        int[] arr=b.createArr(10);
        //b.bSearch();
        shuffle f=new shuffle();
        f.readArray(arr);
        b.bSearch(arr,1);

    }
    void bSearch(int[] arr,int num){
        int start=0,end=arr.length-1,times=0;
        while (start<=end){
            times++;
            int half=(start+end)/2;
            if(arr[half]==num){
                System.out.println("The local is:"+half);
                break;
            }else if(arr[half]<num){
                start=half+1;
            }else if(arr[half]>num){
                end=half-1;
            }

        }
        System.out.println("RunTimes:"+times);
    }
     int[] createArr(int n){
        int[] a=new int[n];
        for (int i=1;i<=n;i++){
            a[i-1]=i;
        }
        return a;
    }
}
