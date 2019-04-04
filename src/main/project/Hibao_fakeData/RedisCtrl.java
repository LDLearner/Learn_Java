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
   public Jedis con=conRedis();
    final String host="10.0.5.226";
    Jedis jedis=null;
    private Jedis conRedis() {
        if (jedis == null) {
            System.out.println("Redis is Connect!!!");
           jedis = new Jedis(host, 6380);
        }
        return jedis;
    }

    public void closeRedis(){
        try {
            if(con!=null)con.close();
        } catch (Exception e) {
        }
    }

    private void setkey(String key,String value){

        con.set(key,value);
    }
    public String getValue(String videoId) throws SQLException, ParseException {
        String value=null;
        if(con.get(videoId)!=null) {
            value = con.get(videoId);
        }else
        {
            MySql mysql=new MySql();
            value=mysql.getCtime(videoId);
            setkey(videoId,value);
        }
        return value;
    }

}
