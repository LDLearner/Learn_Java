package BuilderPattern;


/**
 * Created by LD on 2019/4/4.
 */
public class AirShip {
    private OrbitalModule orbitalModule;//轨道舱
    private Engine engine;//发动机
    private EscapeTower escapeTower;//逃逸塔

    public OrbitalModule getOrbitalModule() {
        return orbitalModule;
    }

    public void setOrbitalModule(OrbitalModule orbitalModule) {
        System.out.println(orbitalModule.getName()+"轨道舱装配完毕");
        this.orbitalModule = orbitalModule;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        System.out.println(engine.getName()+"引擎装配完毕");
        this.engine = engine;
    }

    public EscapeTower getEscapeTower() {
        return escapeTower;
    }

    public void setEscapeTower(EscapeTower escapeTowerame) {
        System.out.println(escapeTowerame.getName()+"逃逸塔装配完毕");
        this.escapeTower = escapeTowerame;
    }

}
