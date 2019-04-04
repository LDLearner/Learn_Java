package Factory.AbstractFactory;

/**
 * Created by LD on 2019/4/3.
 */
public class LuxuryCarFactory implements CarFactory{
    @Override
    public Engine createEngine() {
       return new LuxuryEngine();
    }

    @Override
    public Seat createSeat() {
        return new LuxurySeat();
    }
    @Override
    public Tyre createTyre() {
        return new LuxuryTyre();
    }

}
