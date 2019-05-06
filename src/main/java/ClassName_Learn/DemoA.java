package ClassName_Learn;

/**
 * Created by LD on 2018/11/20.
 * Class.forName中不包含initialize参数，这样在加载类时会立即运行静态区块
 */
public class DemoA {
    public static void main(String[] args) {

        try {
            System.out.println("载入 TestClass ");
            Class c = Class.forName("com.mysql.jdbc.Driver");

            System.out.println("使用 TestClass 声明参考名称");
            TestClass test = null;

            System.out.println("使用 TestClass 建立对象");
            test = new TestClass();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("没有指定类名称");
        } catch (ClassNotFoundException e) {
            System.out.println("找不到指定的类");
        }
    }
}
