/**
 * Created by jjjjj on 2017/11/21.
 * 用于学习java实例变量、局部变量和类变量
 */
public class Java_String {
    static int classVar=1000;   //类变量全局使用，累计每次操作
    int instanceVar=100;
    public void func(int a){
            int localVar=1;
            localVar+=a;
            instanceVar+=a;
            classVar+=a;
            System.out.println("localVar="+localVar);
            System.out.println("instanceVar="+instanceVar);
            System.out.println("classVar="+classVar);
    }
    //public int getVar=


    public static void main(String args[]) {
        int a=1;
        Java_String c=new Java_String();
        Java_String d=new Java_String();
        c.func(1);
        c.func(1);
        d.func(1);
        //System.out.println("c="+);
    }





   // System.out.println("v");
}
