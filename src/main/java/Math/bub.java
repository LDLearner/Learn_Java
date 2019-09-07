package Math;
/**
 * Created by LD on 2019/4/24.
 * 冒泡算法，时间复杂度(n-1) + (n-2) + (n-3) + … + 1 = n*(n-1)/2;
 */
public class bub {
    public static void main(String[] args) {
        shuffle arr=new shuffle();
        int[] a=arr.ShuffleArray(4);
        arr.readArray(a);
        runbub(a);
        System.out.println("---------------------------------------------------------------------");
        arr.readArray(a);
    }
     static void runbub(int[] a){
         int runTimes=0;
        for(int i=0;i<a.length-1;i++){
            for(int j=i+1;j<a.length;j++){
                if(a[i]>a[j]){
                    int temp=a[i];
                    a[i]=a[j];
                    a[j]=temp;
                }
                runTimes++;
            }

        }
         System.out.println("Total RunTimes:"+runTimes);
    }




}
