package File;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by LD on 2018/11/23.
 * 字节流读取文件
 * 通过FileInputStream和FileOutputStream复制图片
 */
public class FileInputStream_Test {
    public static void main(String[] args) {

        File f=new File("D:\\1.jpg");
        File destination =new File("E:\\1.jpg");
        char context;
        try {
            //1.创建文件 输入流从系统文件获取字节
            FileInputStream fis=new FileInputStream(f);
            //2.创建文件输出流将数据写入系统文件
            FileOutputStream fos=new FileOutputStream(destination);
            System.out.println("文件大小"+fis.available());
            ///3.保存字节数
            byte[] b=new byte[fis.available()];
            //4.输入流读取字节数，并保存到字节数组中
            fis.read(b);
            //5.将字节数组写入目标文件中
            fos.write(b);
            System.out.println("成功复制图片");
            //6.最后关闭输入输出流，释放连接资源
            fis.close();
            fos.close();
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IOException ");
            e.printStackTrace();
        }

    }
}
