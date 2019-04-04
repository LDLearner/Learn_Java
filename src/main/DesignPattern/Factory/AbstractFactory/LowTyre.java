package Factory.AbstractFactory;

/**
 * Created by LD on 2019/4/3.
 */
public class LowTyre implements Tyre {
    @Override
    public void brand() {
        System.out.println("杂牌轮胎");
    }
}
