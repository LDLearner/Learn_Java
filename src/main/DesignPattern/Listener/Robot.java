package Listener;

/**
 * Created by LD on 2019/5/14.
 * 事件源：机器人
 */

public class Robot {

    private RobotListener listener;
    /**
     * 注册机器人监听器
     * @param listener
     */
    public void registerListener(RobotListener listener){
        this.listener  = listener;
    }
    /**
     * 工作
     */
    public void working(){
        if(listener!=null){
            Even even = new Even(this);
            this.listener.working(even);
        }
        System.out.println("机器人开始工作......");
    }
    /**
     * 跳舞
     */
    public void dancing(){
        if(listener!=null){
            Even even = new Even(this);
            this.listener.dancing(even);
        }
        System.out.println("机器人开始跳舞......");
    }


}