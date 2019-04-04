package Factory.AbstractFactory;

/**
 * Created by LD on 2019/4/3.
 */
public class TheCar {
    public void CreateCar(String Level) throws Exception{
        CarFactory factory=null;
        if(Level.equals("luxury")){
            System.out.println("豪华汽车开始创建");
            factory = new LuxuryCarFactory();
        }
        else if(Level.equals("low")){
            System.out.println("经济型汽车开始创建");
            factory = new LowCarFactory();
        }
        else
        {
            System.out.println("没有该规则的汽车，请检查输入！");
        }
        Engine engine = factory.createEngine();//创建发动机
        Seat seat=factory.createSeat();
        Tyre tyre=factory.createTyre();
        engine.run();
        engine.start();
        seat.material();
        tyre.brand();
    }

}
