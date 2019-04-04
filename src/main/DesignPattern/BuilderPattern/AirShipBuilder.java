package BuilderPattern;

/**
 * Created by LD on 2019/4/4.
 */
public interface AirShipBuilder {
    Engine builderEngine();//构建发动机
    OrbitalModule builderOrbitalModule();//构建轨道舱
    EscapeTower builderEscapeTower();//构建逃逸塔
}
