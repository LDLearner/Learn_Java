package BuilderPattern;

/**
 * Created by LD on 2019/4/4.
 * 具体飞船的构造
 */
public class FzAirShipBuilder implements AirShipBuilder{
    @Override
    public Engine builderEngine() {
        System.out.println("万能牌发动机引擎"+"构建成功");
        return new Engine("万能牌发动机");
    }
    @Override
    public OrbitalModule builderOrbitalModule() {
        System.out.println("万能牌轨道舱"+"构建成功");
        return new OrbitalModule("万能牌轨道舱");
    }
    @Override
    public EscapeTower builderEscapeTower() {
        System.out.println("万能牌逃逸塔"+"构建成功");
        return new EscapeTower("万能牌逃逸塔");
    }
}
