package File;

import java.io.*;

/**
 * Created by LD on 2018/11/23.
 * 字符流读取
 * BufferedReader和BufferedWriter的使用
 */
public class BufferedReader {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("F:\\in.txt");
        String s;
        java.io.BufferedReader br = new java.io.BufferedReader(new FileReader(file));
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("F:\\file.txt"));
            while((s = br.readLine())!= null){
                bw.write(s);
                bw.newLine();
                bw.flush();
                bw.write("GinSmile");
                bw.newLine();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

}
