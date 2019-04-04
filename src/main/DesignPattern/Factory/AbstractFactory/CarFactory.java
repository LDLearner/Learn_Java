package Factory.AbstractFactory;

/**
 * Created by LD on 2019/4/3.
 */
public interface CarFactory {
    Engine createEngine();//创建发动机
    Seat createSeat();//创建座椅
    Tyre createTyre();//创建轮胎
}
