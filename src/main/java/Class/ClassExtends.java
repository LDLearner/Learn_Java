package Class;

/**
 * Created by LD on 2018/11/26.
 * 继承，类，超类和子类
 */
public class ClassExtends {

        public static void main(String[] args) {
            Employee[] staff = new Employee[3];
            staff[0] = new Employee("Bob", 1000);
            staff[1] = new Manager("Jim", 5000, 1000);
            staff[2] = new Boss("Alice", 7000, 1000, 10000);

            for(Employee e : staff)
                System.out.println("class name:" + e.getClass().getName() + "\tid:" + e.getId() +
                        "\tname:" + e.getName() + "\tsalary:" + e.getSalary());

            Manager man = (Manager)staff[1];
            Boss boss = (Boss)staff[2];
            System.out.println(man.getBonus());//类型转换后就可以使用实际类型的全部功能
            System.out.println(boss.getAward());

            //ClassCastException异常,不允许进行继承链上的从上到下的转换
            //Boss myBoss = (Boss)staff[0];

            //把instaceof运算符和类型转换组合起来，避免异常
            //instaceof作用是判断某一个实例是否属于某种类型
            if(staff[0] instanceof Boss){
                System.out.println("staff[0] is a instace of Boss");
                Boss myBoss = (Boss) staff[0];
            }
            else System.out.println("staff[0] isn't a instace of Boss");

            if(staff[2] instanceof Boss){
                System.out.println("staff[2] is a instace of Boss");
            }
            else System.out.println("staff[2] isn't a instace of Boss");


        }
    }

    class Employee {
        public Employee(String name){
            this.name = name;
            id = nextId;
            nextId++;
        }

        public Employee(String name, double salary){
            this(name);//调用另一构造器
            this.salary = salary;
        }

        //定义访问器方法
        public final String getName(){
            return name;
        }

        public double getSalary(){
            return salary;
        }

        public final int getId(){
            return id;
        }


        //定义更改器方法
        public final void setName(String name){
            this.name = name;
        }

        public final void setSalary(double salary){
            this.salary = salary;
        }

        public final void raiseSalary(double percent){
            this.salary *= (1 + percent);
        }

        //定义变量
        private String name = "";//实例域初始化
        private double salary;
        private int id;
        private static int nextId = 1;


    }

    class Manager extends Employee{
        public Manager(String name, double salary, double bonus){
            super(name, salary);//super在构造器中的使用，可以调用超类的构造器
            setBonus(bonus);
        }

        public double getBonus(){
            return bonus;
        }

        //重写getSalary方法
        public double getSalary(){
            double baseSalary = super.getSalary();//调用了超类的getSalary方法
            return baseSalary + bonus;
        }

        public void setBonus(double bonus){
            this.bonus = bonus;
        }

        private double bonus;
    }

final class Boss extends Manager{
        public Boss(String name, double salary, double bonus, double award){
            super(name, salary, bonus);
            this.award = award;
        }

        //重写getSalary方法
        public double getSalary(){
            double baseSalary = super.getSalary();//调用了超类的getSalary方法
            return baseSalary + award;
        }

        public double getAward(){
            return award;
        }
        private double award;
}

//////////////////////////接口部分/////////////////////////////////////


//////////////////////////接口部分/////////////////////////////////////