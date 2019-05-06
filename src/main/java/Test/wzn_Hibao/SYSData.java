package Test.wzn_Hibao;

/**
 * Created by TS on 2017/03/05
 * 用于实现存储系统数据，与被测系统的MySQL、ZooKeeper、Jedis数据
 * */
import java.io.File;

public class SYSData {
	/** ----------------------------------------------------------------------------------------------------------------------------- */
	public static String DB_Driver = "com.mysql.jdbc.Driver";
	// 后台
	public static String DB_URL_HeFan = "jdbc:mysql://hf-mix-01.mysql.rds.aliyuncs.com:3306/hefantv_qa";
	public static String DB_User_HeFan = "hefantv_qa_test";
	public static String DB_Pass_HeFan = "hJZntz1TRVpCtYAG";
	// 活动
	public static String DB_URL_HeFanLottery = "jdbc:mysql://hf-mix-01.mysql.rds.aliyuncs.com:3306/hefanlottery_qa";
	public static String DB_User_HeFanLottery = "qa_hd_ht";
	public static String DB_Pass_HeFanLottery = "yQE8FjUHTdILQmXg";
	// 订单
	public static String DB_URL_hfoms = "jdbc:mysql://hf-mix-01.mysql.rds.aliyuncs.com:3306/hf_oms_qa";
	public static String DB_User_hfoms = "hf_oms_qa_test";
	public static String DB_Pass_hfoms = "Ri2nDfBm5oJ8";
	// 俱乐部
	public static String DB_URL_HeFanClub = "jdbc:mysql://hf-mix-01.mysql.rds.aliyuncs.com:3306/hefanclub_qa";
	public static String DB_User_HeFanClub = "hfclub_qa_test";
	public static String DB_Pass_HeFanClub = "qSZmsMGxNEX1IT1y";
	// 嗨爆
	public static String DB_URL_QA = "jdbc:mysql://rm-2ze26x8763n9y5889.mysql.rds.aliyuncs.com:3306/hb_qa";
	public static String DB_User_QA = "hefan_test";
	public static String DB_Pass_QA = "#9e3BOX1fG-#e";

	/** ----------------------------------------------------------------------------------------------------------------------------- */
	// 盒饭
	public static String Redis_Host_HeFan = "hf-test-01.redis.rds.aliyuncs.com";
	public static String Redis_Auth_HeFan = "r-2ze26dab2cf08f84:HefanRE8v97c";
	public static int Redis_Port_HeFan = 6379;
	// 嗨爆
	public static String Redis_Host_HiBao = "hb-mix-01.redis.rds.aliyuncs.com";
	public static String Redis_Auth_HiBao = "XdwLpd7WSLPs";
	public static int Redis_Port_HiBao = 6379;

	/** ----------------------------------------------------------------------------------------------------------------------------- */
	// 盒饭
	public static String ZK_Host_HeFan = "172.16.60.61:2181";

	/** ----------------------------------------------------------------------------------------------------------------------------- */
	// public static String appVer = "1.1.31.666";
	public static String appVer = "2.1.4.80";

	/** ----------------------------------------------------------------------------------------------------------------------------- */
	public static File logDirectoryPath = new File("C:\\自动化接口测试日志\\");
	public static File logFilePathAll = new File("C:\\自动化接口测试日志\\Log-" + DateUnit.getDateCurrent("yyyyMMdd-HHmmss全部") + ".txt");
	public static File logFilePathFail = new File("C:\\自动化接口测试日志\\Log-" + DateUnit.getDateCurrent("yyyyMMdd-HHmmss失败") + ".txt");
}