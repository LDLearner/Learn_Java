package File;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by LD on 2018/11/23.
 */
public class PrintWriter_Test {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("F:\\in.txt"));
        PrintWriter pw = new PrintWriter(new File("F:\\file.txt"));
        String name = "GinSmile";
        pw.write(name);//把字符串添加到文件末尾
        pw.append('w');//直接把字符添加到文件末尾
        pw.println();//仅仅打印一个换行符
        while (in.hasNext()) {
            String s = in.nextLine();
            System.out.println(s);
            pw.println(s);
        }

        pw.println(); //添加换行
        pw.printf("%x", 100);//将100由十进制转换成十六进制
        pw.println();
        char[] buf = {'a', 'b', 'c', 'd', 'e', 'f'};
        pw.write(buf, 0, 4);//把字符数组的一部分添加到文件末尾

        pw.close();
    }
}
