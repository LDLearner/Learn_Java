package Factory.AbstractFactory;

/**
 * Created by LD on 2019/4/3.
 */
public class LuxuryTyre implements Tyre{
    @Override
    public void brand() {
        System.out.println("米其林轮胎");
    }
}
