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
    public static void main(String[] args) throws ParseException, SQLException {
       // String Theday="2019-3-07";
       // String videoId="3365";
       // System.out.println("videoCTime="+getCtime("3365"));
    }

    public Connection Getcon(){
        //声明Connection对象
        Connection con = null;
        //驱动程序名
        final String driver = "com.mysql.jdbc.Driver";
        //URL指向要访问的数据库名mydata
        final String url = "jdbc:mysql://rm-2ze26x8763n9y5889.mysql.rds.aliyuncs.com:3306/hb_qa";
        //MySQL配置时的用户名
        final String user = "hefan_test";
        //MySQL配置时的密码
        final String password = "#9e3BOX1fG-#e";
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
        return con;
    }

    public void Closecon(Connection con) throws SQLException {
        con.close();
    }

    public String getCtime(String videoId) throws SQLException, ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String CreateTime=null;
        Connection con=Getcon();
        String sqls = "SELECT create_time FROM hi_video WHERE id=" + videoId;
        Statement statement = con.createStatement();
        ResultSet videoCreateTime = statement.executeQuery(sqls);

        while (videoCreateTime.next()) {
            String SqlDayForStr = sdf.format(videoCreateTime.getDate(1));
            Date sqlDate = videoCreateTime.getDate(1);
            DiffDay diffday=new DiffDay();
            CreateTime=diffday.dateToStamp(SqlDayForStr);
        }
        videoCreateTime.close();
        statement.close();
        Closecon(con);
        return CreateTime;
    }









}
