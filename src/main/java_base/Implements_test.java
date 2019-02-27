/**
 * Created by LD on 2018/11/27.
 * implements接口的使用
 */
public class Implements_test {

    public static void main(String...args) throws CloneNotSupportedException{
        Employee a = new Employee("Lily", 1000);

        Employee staff = a;//a与staff同时引用同一个对象
        a.setName("Bob");
        System.out.println(a);//com.xujin.Employee[name = Bob, salary = 1000.0]
        System.out.println(staff);	//com.xujin.Employee[name = Bob, salary = 1000.0]

        Employee copy = a.clone();
        a.setName("Jim");
        a.setSalary(2000);
        System.out.println(a);//com.xujin.Employee[name = Jim, salary = 2000.0]
        System.out.println(copy);//com.xujin.Employee[name = Bob, salary = 1000.0]
    }
}

class Employee implements Cloneable{ //实现Cloneable接口
    public Employee(String name, double salary){
        this.name = name;
        this.salary = salary;
    }

    public String getName(){
        return this.name;
    }

    public double getSalary(){
        return this.salary;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setSalary(double salary){
        this.salary = salary;
    }

    public String toString(){
        return getClass().getName() + "[name = " + name + ", salary = " + salary + "]";
    }

    public Employee clone() throws CloneNotSupportedException{
        return (Employee)super.clone();
    }

    //定义变量
    private double salary;
    private String name;
}
