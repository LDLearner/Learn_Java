package MySQL;

/**
 * Created by LD on 2018/11/15.
 */
import java.sql.*;

public class InsertDataDemo {
    static Connection conn = null;

    public static void initConn() throws ClassNotFoundException, SQLException {

        String url = "jdbc:mysql://10.0.5.226:3306/test";
        String user = "root";
        String password = "";

        try {
            // 动态加载mysql驱动
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动程序");
            conn = DriverManager.getConnection(url,user,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static String randomStr(int size) {
        //定义一个空字符串
        String result = "";
        for (int i = 0; i < size; ++i) {
            //生成一个97~122之间的int类型整数
            int intVal = (int) (Math.random() * 26 + 97);
            //强制转换（char）intVal 将对应的数值转换为对应的字符，并将字符进行拼接
            result = result + (char) intVal;
        }
        //输出字符串
        return result;
    }

    public static int select() {
        int num=0;
        String select_sql = "select * from students order by id DESC limit 1";
        try {
            String id = null;
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(select_sql);
            while(rs.next())
            {
            id = rs.getString("id");
            }
            num = Integer.parseInt(id);
            System.out.println("num="+id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    return num;
    }

    public static void insert(int insertNum) {
        int num=select();
        // 开时时间
        Long begin = System.currentTimeMillis();
        System.out.println("开始插入数据...");
        // sql前缀
        String prefix = "INSERT INTO students (id,name,age,sex,class) VALUES ";

        try {
            // 保存sql后缀
            StringBuffer suffix = new StringBuffer();
            // 设置事务为非自动提交
            conn.setAutoCommit(false);
            PreparedStatement pst = conn.prepareStatement("");
            for (int i = num+1; i <= insertNum+num; i++) {
                // 构建sql后缀
                suffix.append("(Null,'学生"+i+"','12','1','2'),");
            }
            // 构建完整sql
            String sql = prefix + suffix.substring(0, suffix.length() - 1);
            // 添加执行sql
            pst.addBatch(sql);
            // 执行操作
            pst.executeBatch();
            // 提交事务
            conn.commit();

            // 关闭连接
            pst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 结束时间
        Long end = System.currentTimeMillis();
        System.out.println("插入"+insertNum+"条数据数据完成！");
        System.out.println("耗时 : " + (end - begin) / 1000 + " 秒");
    }


    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        int i=0;
        while(i<10){
            i++;
            initConn();
            insert(500000);
        }
    }
}


