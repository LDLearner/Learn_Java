package Math;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by LD on 2019/4/24.
 * shuffle洗牌算法，将1-N的整数随机分配到数组中，无重复
 * 该程序为解决该题目：用最小的时空复杂度找到这个-1的位置和被修改的数字
 */
public class shuffle {
    public static void main(String[] args) {
        int[] a=ShuffleArray(1000);
        randomEdit(a);
        shuffle shuffle=new shuffle();
        shuffle.readArray(a);
        long startTime=System.currentTimeMillis();
        System.out.println(FindTheLocal(a));
        long endTime=System.currentTimeMillis(); //获取结束时间
        System.out.println(FindTheNum(a));
        assertTheNum(a,FindTheNum(a));
        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
        FindTheLocal2(a);
    }
    static int[] ShuffleArray(int n){
        int[] a=new int[n];
        for (int i=1;i<=n;i++){
            a[i-1]=i;
        }
        Random rand = new Random();
        //开始洗牌
        for (int i=0;i<n;i++){
            int r=rand.nextInt(a.length);
            int temp=a[i];
            a[i]=a[r];
            a[r]=temp;
        }
        return a;
    }
    static void randomEdit(int[] arr){
        Random rand = new Random();
        int r=rand.nextInt(arr.length);
        System.out.println("r="+r);
        arr[r]=-1;
    }
    static int FindTheLocal(int[] arr){
        int i=1;
        for(i=1;i<arr.length;i++){
            if(arr[i]+arr[i-1] < arr[i-1]){
                break;
            }
        }
        return i;
    }
    static int FindTheLocal2(int[] arr){
        Arrays.sort(arr);
        int i=Arrays.binarySearch(arr,-1);
        System.out.println("find2:"+i);
        return i;
    }

    static int FindTheNum(int[] arr){
        int arrSum=0;
        for(int i=0;i<arr.length;i++){
            arrSum+=arr[i];
        }
        int Thenum=arr.length*(1+arr.length)/2-arrSum-1;  //使用1-N项和的公式：Sn=n（a1+an）/2 ，公式中首项为a1，末项为an，项数为n，公差为d，前n项和为Sn
        return Thenum;
    }
    static boolean assertTheNum(int[] arr,int TheNum){
        boolean res=true;
        for (int i=0;i<arr.length;i++){
            if(arr[i]==TheNum){
                System.out.println("find TheNum local:"+i);
                res=false;
                break;
            }
        }
        System.out.println("TheNum is:"+res);
        return res;
    }
    static void readArray(int[] array){
        for (int i=0;i<array.length;i++){
            System.out.println("Arr["+i+"]="+array[i]);
        }
    }
}
