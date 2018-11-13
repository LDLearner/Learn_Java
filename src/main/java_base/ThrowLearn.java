/**
 * Created by LD on 2018/9/4.
 */
class Math{
    public int div(int i,int j) throws Exception{    // 定义除法操作，如果有异常，则交给被调用处处理
        int temp = i / j ;    // 计算，但是此处有可能出现异常
        return temp ;
    }
}
public class ThrowLearn {
    public static void main(String args[]){
        Math m = new Math() ;        // 实例化Math类对象
        try{//因之前用throws将异常由调用处处理，此处需添加try进行异常捕获
            System.out.println("除法操作：" + m.div(10,2)) ;
        }catch(Exception e){
            e.printStackTrace() ;    // 打印异常
        }
    }
}
