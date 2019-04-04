package ExceptionHandling;

/**
 * Created by LD on 2018/9/4.
 */
public class ThrowLearn {
    public static void main(String args[]) throws Exception {
        ExceptionHanding(10,0);
        NoExceptionHanding(10,0);
    }


    public static void ExceptionHanding(int a,int b){
        Math m = new Math() ;        // 实例化Math类对象
        try{//因之前用throws将异常由调用处处理，此处需添加try进行异常捕获
            System.out.println("除法操作：" + m.div(a,b)) ;
        }catch(Exception e){
            //e.printStackTrace() ;    // 打印异常
            System.out.println("捕获到异常并对其处理");
        }
        System.out.println("进行异常处理的程序结束！"); //因处理了异常，所以程序可继续执行
}
    public static void NoExceptionHanding(int a,int b) throws Exception{ //只抛出异常，不处理
        Math m = new Math() ;        // 实例化Math类对象
        System.out.println("除法操作：" + m.div(a,b)) ;
        System.out.println("没有进行异常处理的程序结束！"); //没有处理异常，所以程序停止，该行不会被执行

    }

}
