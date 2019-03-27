package Hibao_fakeData;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by LD on 2019/3/14.
 */
public class MySql {
    //要执行的SQL语句
    //static String sqls="insert into student_score values('','学生','0','0')";
    // static String sqls="insert into student_score values('','0','0','0')";
    public static void main(String[] args) throws ParseException {
       // String Theday="2019-3-07";
       // String videoId="3365";
       // System.out.println("result="+getDate (videoId,Theday));
    }
     public static int getDate (String videoId,String TheDate) {
         SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
         SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
         java.util.Date TD= null;
         try {
             TD=sdf.parse(TheDate);
         } catch (ParseException e) {
             e.printStackTrace();
         }
         long days=0;
            //声明Connection对象
            Connection con;
            //驱动程序名
            String driver = "com.mysql.jdbc.Driver";
            //URL指向要访问的数据库名mydata
            String url = "jdbc:mysql://rm-2ze26x8763n9y5889.mysql.rds.aliyuncs.com:3306/hb_qa";
            //MySQL配置时的用户名
            String user = "hefan_test";
            //MySQL配置时的密码
            String password = "#9e3BOX1fG-#e";
            //遍历查询结果集
            try {
                //加载驱动程序
                Class.forName(driver);
                //1.getConnection()方法，连接MySQL数据库！！
                con = DriverManager.getConnection(url, user, password);
                if (!con.isClosed()) {
                   // System.out.println("Succeeded connecting to the Database!");
                }
                //2.创建statement类对象，用来执行SQL语句！！
                Statement statement = con.createStatement();
                //3.ResultSet类，用来存放获取的结果集！！
                //String sqls="insert into student_score values('','学生"+a+"','0','0')";
                String sqls = "SELECT create_time FROM hi_video WHERE id="+videoId;
                ResultSet videoCreateTime = statement.executeQuery(sqls);
                while (videoCreateTime.next()) {
                    String TheDayForStr = sdf.format(TD);
                    String SqlDayForStr = sdf.format(videoCreateTime.getDate(1));
                    Date sqlDate=videoCreateTime.getDate(1);

                    if (TheDayForStr.equals(SqlDayForStr))                  //创建日期为当天的逻辑
                    {
                        long Sqltime=videoCreateTime.getTimestamp(1).getTime();
                        long Thetime=sqlDate.getTime()+24*60*60*1000;
                        long diff=(Thetime-Sqltime)/1000/3600;
                        System.out.println(diff);
                        if(diff<1){
                            days=-1000;
                        }
                        else if(diff>=1&&diff<5){
                            days=-2000;
                        }
                        else if(diff>=5&&diff<10){
                            days=-3000;
                        }
                        else if(diff>=10&&diff<24){
                            days=-4000;
                        }
                        else{
                            System.out.println("diff is error!!!");
                        }
                        System.out.print("diffDay="+days+",");
                    }
                    else                                                        //创建日期为非当天的逻辑
                    {
                        days=(TD.getTime()-sqlDate.getTime())/(1000*3600*24)+1;
                        System.out.print("diffDay="+days+",");

                    }

                }
                videoCreateTime.close();
                statement.close();
                con.close();
            } catch (ClassNotFoundException e) {
                //数据库驱动类异常处理
                System.out.println("Sorry,can`t find the Driver!");
                e.printStackTrace();
            } catch (SQLException e) {
                //数据库连接失败异常处理
                e.printStackTrace();
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            } finally {
                //System.out.println("数据库数据成功获取！！");
            }
         return (int)days;
    }

}
