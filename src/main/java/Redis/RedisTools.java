package Redis;

/**
 * Created by LD on 2018/11/12.
 * Redcis连接池操作
 */

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisTools {

    /**
     * 私有构造器
     */
    private RedisTools(){};

    private static JedisPool JEDIS_POOL = null;

    /**
     * 从连接池中获取链接
     * @return
     */
    public static synchronized Jedis getJedis()
    {
        if(null == JEDIS_POOL)
        {
            //1:获取连接池类
            JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
            //2:设置最大空闲连接数
            jedisPoolConfig.setMaxIdle(10);
            //3:设置最大连接数
            jedisPoolConfig.setMaxTotal(100);
            //4:设置创建链接的超时时间
            jedisPoolConfig.setMaxWaitMillis(3000);
            //5:设置创建连接时是否会测试链接是否可用
            jedisPoolConfig.setTestOnBorrow(true);
            //6:获取连接池，在其中指定ip和端口
            JEDIS_POOL = new JedisPool(jedisPoolConfig, "10.0.5.226", 6380);
        }
        //7:从连接池中获取一个链接
        return JEDIS_POOL.getResource();
    }

    /**
     * 返回链接
     * @param jedis
     */

    public static void returnResource(Jedis jedis)
    {
        if(null != jedis)
        {
            jedis.close();
        }
    }
}
