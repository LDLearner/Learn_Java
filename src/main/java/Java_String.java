/**
 * Created by LD on 2017/11/21.
 * 用于学习java实例变量、局部变量和类变量
 * 运行结果展示了各种类型的变量的作用域和生存周期
 */
public class Java_String {
    static int classVar=1000;   //类变量（静态变量）全局使用，累计每次操作
    int instanceVar=100;    //实例变量(成员变量)，在实例内部使用，每个实例创建单独副本
    public void func(int a){
            int localVar=1; //局部变量，在方法内部使用，方法结束后消亡
            localVar+=a;
            instanceVar+=a;
            classVar+=a;
            System.out.println("localVar="+localVar);
            System.out.println("instanceVar="+instanceVar);
            System.out.println("classVar="+classVar);
    }
    public int getinstanceVar(){
        return  instanceVar;
    }

    public int setinstanceVar(int instanceVar){
        this.instanceVar=instanceVar;
        return  instanceVar;
    }

    public static void main(String args[]) {
        Java_String c=new Java_String();
        Java_String d=new Java_String();
        c.func(1);
        c.func(1);
        d.func(1);
        //instanceVar=10;   //error，不能直接操作实例变量
        d.setinstanceVar(10);   //可以通过set方法操作实例变量
        System.out.println("instanceVar="+d.getinstanceVar());  //可以通过get方法获取实例变量
    }

}
