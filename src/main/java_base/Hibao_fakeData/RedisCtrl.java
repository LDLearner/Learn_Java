package Hibao_fakeData;

import redis.clients.jedis.Jedis;

import java.sql.SQLException;
import java.text.ParseException;

/**
 * Created by LD on 2019/3/28.
 */
public class RedisCtrl {
    public static void main(String[] args) throws InterruptedException, SQLException, ParseException {
        //System.out.println(getValue("3365"));
    }

    public static void setkey(String key,String value){
        final String host="10.0.5.226";
        Jedis jedis = new Jedis(host,6380);
        jedis.set(key,value);
        jedis.close();
    }
    public static String getValue(String videoId) throws SQLException, ParseException {
        final String host="10.0.5.226";
        String value="none";
        Jedis jedis = new Jedis(host,6380);
        if(jedis.get(videoId)!=null) {
            value = jedis.get(videoId);
        }else
        {
            MySql mysql=new MySql();
            value=mysql.getCtime(videoId);
            setkey(videoId,value);
        }
        jedis.close();
        return value;
    }

}
