package Factory.AbstractFactory;

/**
 * Created by LD on 2019/4/3.
 */
class LowEngine implements Engine{
    @Override
    public void run() {
        System.out.println("转的慢");
    }
    @Override
    public void start() {
        System.out.println("启动慢");
    }
}