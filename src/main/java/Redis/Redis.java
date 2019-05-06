package Redis;

import redis.clients.jedis.Jedis;

/**
 * Created by LD on 2018/11/5.
 * 建立Redis连接并操作
 */
public class Redis {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("start");
        /**
         * 单链接
         */
             //获取redis链接
            final String host="10.0.5.226";
            Jedis jedis = new Jedis(host,6380);
            //通过命令来操作redis
            jedis.set("javaname", "jack");
            String name = jedis.get("javaname");
            System.out.println("javaname="+name);
            //jedis.del("javaname");
            //:关闭redis链接
/*
        try {
                MutilThread.sleep(5000);
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
*/
        TestWatch tw=new TestWatch();
        try {
            tw.testWatch();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        jedis.close();

    }
}
