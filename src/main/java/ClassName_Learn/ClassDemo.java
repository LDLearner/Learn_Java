package ClassName_Learn;

/**
 * Created by LD on 2018/11/22.
 */
public class ClassDemo {
    public static void main(String[] args) {

        try {
            String classname="ClassName_Learn.TestClass";
            Class c = Class.forName(classname);
            System.out.println("类名称：" + c.getName());
            System.out.println("是否为接口：" + c.isInterface());
            System.out.println("是否为基本类型：" + c.isPrimitive());
            System.out.println("是否为数组：" + c.isArray());
            System.out.println("父类：" + c.getSuperclass().getName());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("没有指定类名称");
        } catch (ClassNotFoundException e) {
            System.out.println("找不到指定的类");
        }
    }
}
