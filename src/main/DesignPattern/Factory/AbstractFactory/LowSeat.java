package Factory.AbstractFactory;

/**
 * Created by LD on 2019/4/3.
 */
public class LowSeat implements Seat {
    @Override
    public void material() {
        System.out.println("皮革座椅");
    }
}
