package Listener;

/**
 * Created by LD on 2019/5/14.
 * 事件监听器测试类
 * 本程序模式监听模式
 */
public class TestListener {

    public static void main(String[] args) {
        Robot robot = new Robot();
        robot.registerListener(new MyRobotListener());
        robot.working();
        robot.dancing();
    }
}
