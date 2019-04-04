package Factory.AbstractFactory;

/**
 * Created by LD on 2019/4/3.
 */
class LuxuryEngine implements Engine{
    @Override
    public void run() {
        System.out.println("好发动机转的快");
    }
    @Override
    public void start() {
        System.out.println("启动快，自动启停");
    }
}
