package Class;

/**
 * Created by LD on 2019/2/26.
 * 通过反射获取类的信息
 */

import java.lang.reflect.Method;

class Reflect
{
    public static void main (String[] args) throws java.lang.Exception
    {
        A log=new A();
       // A a=new A();
        B b=new B();
        Object c=b.getClass();                  //通过getClass生成Class对象的引用
        String d=b.getClass().getName();        //通过getName获取Class对象名
        Class cl = Class.forName(d);            //通过forName生成Class对象的引用
        Class c2 = B.class;                     //通过.class生成Class对象的引用
        Class c3=b.getClass();

        //创建类对象
        System.out.println(c);                  //因为都有toString（）所以动态绑定了
        System.out.println(d);

        Method[] publie_Method=c3.getMethods(); //获取cl类中所有公有方法
        System.out.println("该类所有公有方法:");
        for(Method m:publie_Method)
        {
            System.out.println(m);
        }

        ////////////////////////////////////////////

        System.out.println("B类的字面常量为："+c2);

    }
}

class A
{
    int x;
    int y;
    A()
    {
        // Scanner input=new Scanner(System.in);
        x=10;
        y=9;
        System.out.println("this.getClass() ---->" + this.getClass());
        //input.Close();
    }
    public void Add()
    {
        System.out.println(x+y);
    }


}

class B extends A
{

    public void Add()
    {
        System.out.println(x*y);
    }
    public void TES()
    {
        super.Add();
        this.Add();
    }

}

