package Redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.List;

/**
 * Created by LD on 2018/11/12.
 * watch命令监控键值是否被修改
 */
public class TestWatch{


    public void testWatch() throws InterruptedException
    {
        //1:从jedis连接池中获取链接
        Jedis jedis = RedisTools.getJedis();
        //2:使用watch命令监控k1，可同时监控多个key
        //jedis.watch("k1");

        //3:获得k1的值并加1
        String value = jedis.get("k1");
        int num = Integer.valueOf(value);
        num++;

        //4:此处休眠10秒模拟有其他客户端在修改k1，我们通过redis-cli来完成此操作
        Thread.sleep(10000);

        //5:事务操作,k1的value加1
        Transaction multi = jedis.multi();
        multi.set("k1", num + "");
        List<Object> formatted = multi.exec();
        //System.out.println("formatted="+formatted);

        //6:根据监控判断本事务是否执行
        //exec命令执行成功返回[OK]，执行失败返回[]
        if("[]" == formatted.toString())
        {
            System.out.println("监控到有其他事务修改k1，阻止本事务的操作");
            System.out.println("k1:" + jedis.get("k1"));
            testWatch();
        }
        else
        {
            System.out.println("没有其他事务修改k1，本事务正常执行");
            System.out.println("k1:" + jedis.get("k1"));
        }
    }
}
