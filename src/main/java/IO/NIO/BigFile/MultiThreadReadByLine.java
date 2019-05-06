package IO.NIO.BigFile;

/**
 * Created by LD on 2019/4/8.
 */
public class MultiThreadReadByLine {
    public static void main(String[] args){
        long startTime=System.currentTimeMillis();   //获取开始时间
        String path= MultiThreadReadByLine.class.getClassLoader().getResource("123.txt").getPath();
        FileReader fileReader = new FileReader(path,1000,2);
        fileReader.startRead();
        long endTime=System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
        System.out.println("执行次数"+ ReadFile_NIO.totaltimes);
        System.out.println("错误次数"+ ReadFile_NIO.errortimes);
    }
}
