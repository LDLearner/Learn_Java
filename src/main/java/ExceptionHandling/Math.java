package ExceptionHandling;

/**
 * Created by LD on 2019/4/3.
 */
public class Math {
    public int div(int i,int j) throws Exception{    // 定义除法操作，如果有异常，则交给被调用处处理
        int temp = i / j ;    // 计算，但是此处有可能出现异常
        return temp ;
    }
}
