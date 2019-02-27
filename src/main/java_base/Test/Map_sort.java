package Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by LD on 2019/2/19.
 */
public class Map_sort {
    public static void main(String[] args) {
        Map<String, String> map=new HashMap<String,String>();
        map.put("key3", "value2");
        map.put("key4", "value1");
        map.put("key1", "value3");
        map.put("key2", "value4");
        System.out.println("map0="+map.get("key1"));
        for (String t:map.keySet()) {
           // Log.e("test","key="+t);
        }
    }

}
