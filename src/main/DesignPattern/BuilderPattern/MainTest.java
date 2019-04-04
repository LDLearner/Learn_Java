package BuilderPattern;

/**
 * Created by LD on 2019/4/4.
 * 建造者模式是将一个复杂的构建与其表示相分离，使得同样的构建过程可以创建不同的表示。 [构建与表示分离，同构建不同表示]
 * 将构建零件（builder）和组装零件（director）两个操作给分开
 */
public class MainTest {
        public static void main(String[] args) {

            AirShipDirector shipDirector = new FzAirShipDirector(new FzAirShipBuilder());
            AirShip airShip = shipDirector.directorAirShip();//构建对象
            //System.out.println(airShip.getEngine().getName());  //获取该飞船的引擎品牌
        }
}
