package Factory.AbstractFactory;

/**
 * Created by LD on 2019/4/3.
 */
public class LowCarFactory implements CarFactory{
    @Override
    public Engine createEngine() {
        return new LowEngine();
    }
    @Override
    public Seat createSeat() {
        return new LowSeat();
    }
    @Override
    public Tyre createTyre() {
        return new LowTyre();
    }
}
