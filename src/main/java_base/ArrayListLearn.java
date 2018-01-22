import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LD on 2017/12/2.
 * JAVA数组练习
 */
public class ArrayListLearn {
    //class
    public static void main(String[] args) {
        //定义数组，长度固定
        String[] a = new String[2];
        a[0]="hello";
        a[1]="word!";
        System.out.println(a[0]+" "+a[1]);
        //定义动态数组ArrayList，长度不固定
        List<String> ldlist=new java.util.ArrayList();
        ldlist.add("hi,");
        ldlist.add("GG");
        ldlist.add("Come Here!");
        ldlist.set(1, "PLMM");              //修改ArrayList中的元素
        ldlist.remove(2);                   //删除ArrayList中的元素
        if(ldlist.contains("PLMM")){        //查询ArrayList中的元素
            System.out.println("发现PLMM!");
        }
        for (Object ListElement:ldlist)     //foreach的用法
        {
            System.out.print(ListElement);
        }


    }
}
