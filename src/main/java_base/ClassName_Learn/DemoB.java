package ClassName_Learn;

/**
 * Created by LD on 2018/11/20.
 * Class.forName中包含initialize=false参数，这样在加载类时并不会立即运行静态区块，而会在使用类建立对象时才运行静态区块
 */
public class DemoB {
    public static void main(String[] args) {

        try {
            System.out.println("载入 TestClass ");
            Class c = Class.forName("ClassName_Learn.TestClass", false, Thread.currentThread().getContextClassLoader());

            System.out.println("使用 TestClass 声明参考名称");
            TestClass test = null;

            System.out.println("使用 TestClass 建立对象");
            test = new TestClass();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("没有指定类名称");
        } catch (ClassNotFoundException e) {
            System.out.println("找不到指定的类");
            System.out.println("找不到指定的类");
        }
    }
}
