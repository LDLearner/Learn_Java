package Hibao_fakeData;

import java.io.*;
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
     int errortimes=0,totaltimes=0;
    public void addTotalTimes(){
        totaltimes++;
    }
    public void addErrorTimes(){
        errortimes++;
    }
    public static void main(String[]args){
        {
            long startTime=System.currentTimeMillis();   //获取开始时间
            ReadFile rf=new ReadFile();
            rf.ReadFile("999.txt");
            long endTime=System.currentTimeMillis(); //获取结束时间
            System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
        }
    }
    private void ReadFile(String fileName) {
        try
        {
            //编码格式
            String encoding = "UTF-8";
            //文件路径
            String path=ReadFile.class.getClassLoader().getResource(fileName).getPath();
            File file = new File(path);
            if (file.isFile() && file.exists()){ // 判断文件是否存在
                //输入流
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file), encoding);// 考虑到编码格
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                //读取一行
                DiffDay diffday=new DiffDay();
                RedisCtrl redisctrl=new RedisCtrl();
                while ((lineTxt = bufferedReader.readLine()) != null)
                {
                    addTotalTimes();
                    System.out.print("line"+totaltimes+":");
                    Assert_Letter Assert_Letter=new Assert_Letter();
                    Assert_Num Assert_Num=new Assert_Num();
                    int category=Integer.parseInt(getValue(lineTxt,"category"));
                    String group=getValue(lineTxt,"group");
                    String timestamp=getValue(lineTxt,"timestamp");
                    String videoId=getValue(lineTxt,"videoId");
                    String view=getValue(lineTxt,"view");
                    String share=getValue(lineTxt,"share");
                    String collect=getValue(lineTxt,"collect");
                    String comment=getValue(lineTxt,"comment");
                    String watch=getValue(lineTxt,"watch");
                    String runTime=getValue(lineTxt,"runtime").substring(11);
                    System.out.print("category="+category+",");
                    String lastNum=videoId.substring(videoId.length() -1);
                    boolean AM=false;
                    if(runTime.equals("10:00:00")||runTime.equals("10:10:00")){
                        AM=true;
                    }
                    int diffDay=diffday.getDiffDay(timestamp,redisctrl.getValue(videoId));
                    if(diffDay>0){                                                     //不是当天创建视频，判断档位随机逻辑
                        if(Assert_Letter.Assert_letter(category,diffDay,group,AM)==false){
                            System.out.println("The group is error!!!Line" + totaltimes+":"+ "category=" + category +","+ "group=" + group+"," + "diffDay=" + diffDay);
                            addErrorTimes();
                        }
                    }
                    else {                                                             //当天创建视频，判断档位随机逻辑
                        if (Assert_Letter.Assert_letter_today(diffDay, group)==false) {
                            System.out.println("The group is error!!!Line" + totaltimes+":"+ "category=" + category +","+ "group=" + group+"," + "diffDay=" + diffDay);
                            addErrorTimes();
                        }
                    }
                    Assert_Num.Assert_Num(group,view,comment,collect,share,watch,lastNum);  //判断档位的取值区间逻辑
                //Thread.sleep(1000);
                }
                System.out.println("Total totaltimes is:"+totaltimes);
                System.out.println("Error totaltimes is:"+errortimes);
                read.close();
                redisctrl.closeRedis();
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
    }
    private String getValue(String lineTxt,String StrType) {                //通过正则从日志文件中截取数据
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
            find_result = m.group(0);
        }
        return find_result;
    }


}

