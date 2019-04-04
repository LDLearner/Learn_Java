package Factory.AbstractFactory;

/**
 * Created by LD on 2019/4/3.
 *
 */
public class MainTest {
    public static void main(String[] args) throws Exception {
        TheCar Car = new TheCar();
        try {
            Car.CreateCar("low1");     //想要经济型汽车
            System.out.println("------------------------------------------------------------");
            Car.CreateCar("luxury"); //想要豪华型汽车
            //以后想要中等车的话可以增加相应中等配件的接口
        }catch (Exception E){
            System.out.println("捕获到异常");
        }
        Car.CreateCar("luxury"); //想要豪华型汽车
    }


}
