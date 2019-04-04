package Factory.AbstractFactory;

/**
 * Created by LD on 2019/4/3.
 */
public class LuxurySeat implements Seat {
    @Override
    public void material() {
        System.out.println("真皮座椅");
    }
}
