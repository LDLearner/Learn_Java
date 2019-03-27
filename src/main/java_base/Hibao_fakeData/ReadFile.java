package Hibao_fakeData;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Created by LD on 2019/3/7.
 */
public class ReadFile {
     /**
     * 获取日志文件中的时间
     * @throws FileNotFoundException
     */
    public static void main(String[]args) throws FileNotFoundException {
        {
            long startTime=System.currentTimeMillis();   //获取开始时间
            //匹配次数
            int matchTime = 0;
            //存匹配上的字符串
            List<String> strs = new ArrayList<>();
            try
            {
                //编码格式
                String encoding = "UTF-8";
                //文件路径
                String path=ReadFile.class.getClassLoader().getResource("123.txt").getPath();
                File file = new File(path);
                if (file.isFile() && file.exists()){ // 判断文件是否存在
                    //输入流
                    InputStreamReader read = new InputStreamReader(
                            new FileInputStream(file), encoding);// 考虑到编码格
                    BufferedReader bufferedReader = new BufferedReader(read);
                    String lineTxt = null;
                    //读取一行
                    int times=0,errortimes=0;
                    while ((lineTxt = bufferedReader.readLine()) != null)
                    {
                        times++;
                        System.out.print("line"+times+":");
                        MySql mySql=new MySql();
                        Assert_Letter Assert_Letter=new Assert_Letter();
                        Assert_Num Assert_Num=new Assert_Num();
                        int category=Integer.parseInt(getValue(matchTime, strs, lineTxt,"category"));
                        String group=getValue(matchTime, strs, lineTxt,"group");
                        String timestamp=getValue(matchTime, strs, lineTxt,"timestamp");
                        String videoId=getValue(matchTime, strs, lineTxt,"videoId");
                        String view=getValue(matchTime, strs, lineTxt,"view");
                        String share=getValue(matchTime, strs, lineTxt,"share");
                        String collect=getValue(matchTime, strs, lineTxt,"collect");
                        String comment=getValue(matchTime, strs, lineTxt,"comment");
                        String watch=getValue(matchTime, strs, lineTxt,"watch");
                        String runTime=getValue(matchTime, strs, lineTxt,"runtime").substring(11);
                        System.out.print("category="+category+",");
                        boolean AM=false;
                        String lastNum=videoId.substring(videoId.length() -1);
                        if(runTime.equals("10:00:00")||runTime.equals("10:10:00")){
                            AM=true;
                        }
                        int diffDay=mySql.getDate(videoId,timestamp);
                        if(diffDay>0){
                            if(Assert_Letter.Assert_letter(category,diffDay,group,AM)==false){
                                System.out.println("The group is error!!!Line" + times+":"+ "category=" + category +","+ "group=" + group+"," + "diffDay=" + diffDay);
                                errortimes++;
                             }
                            Assert_Num.Assert_Num(group,view,comment,collect,share,watch,lastNum);
                        }
                        else {
                            Assert_Num.Assert_Num(group,view,comment,collect,share,watch,lastNum);
                            if (Assert_Letter.Assert_letter_today(diffDay, group)==false) {
                                System.out.println("The group is error!!!Line" + times+":"+ "category=" + category +","+ "group=" + group+"," + "diffDay=" + diffDay);
                                errortimes++;
                            }
                        }

                    }
                    System.out.println("Total times is:"+times);
                    System.out.println("Error times is:"+errortimes);
                    read.close();
                }
                else
                {
                    System.out.println("找不到指定的文件");
                }
            }
            catch (Exception e)
            {
                System.out.println("读取文件内容出错");
                e.printStackTrace();
            }

            long endTime=System.currentTimeMillis(); //获取结束时间
            System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
        }
    }

    private static int getMatchTime(int matchTime, List<String> strs, String lineTxt) {
        String RexString="(?<=videoId = ).*?(?=,)";
        Pattern p = Pattern.compile(RexString);
        Matcher m = p.matcher(lineTxt);
        boolean result = m.find();
        String find_result = null;
        if (result)
        {
            matchTime++;
            find_result = m.group(0);
            System.out.println(find_result);
            strs.add(find_result);

        }
        return matchTime;
    }

    private static String getValue(int matchTime, List<String> strs, String lineTxt,String StrType) {
        String RexString="";
        switch(StrType){
            case "videoId":
                RexString="(?<=videoId = ).*?(?=,)";
                break;
            case "category":
                RexString="(?<=category:).*?(?=,)";
                break;
            case "group":
                RexString="(?<=group:).*?(?=,)";
                break;
            case "view":
                RexString="(?<=view:).*?(?=,)";
                break;
            case "share":
                RexString="(?<=share:).*?(?=,)";
                break;
            case "collect":
                RexString="(?<=collect:).*?(?=,)";
                break;
            case "comment":
                RexString="(?<=comment:).*?(?=,)";
                break;
            case "watch":
                RexString="(?<=watch:).*?(?=\")";
                break;
            case "timestamp":
                RexString="(?<=timestamp\":\").*?(?= )";
                break;
            case "runtime":
                RexString="(?<=time:).*?(?=, view:)";
                break;
        }
        Pattern p = Pattern.compile(RexString);
        Matcher m = p.matcher(lineTxt);
        boolean result = m.find();
        String find_result = null;
        if (result)
        {
            matchTime++;
            find_result = m.group(0);
            strs.add(find_result);

        }
        return find_result;
    }


}

