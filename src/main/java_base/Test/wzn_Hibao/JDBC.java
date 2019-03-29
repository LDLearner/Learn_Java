package Test.wzn_Hibao;

/**
 * Created by TS on 2017/03/15
 * 用于实现与被测项目的MySql数据库通信与调用
 * */
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBC {
	public static Connection conn = null;

	public static void connSQL(String database) {
		try {
			if (database.equals("hefan")) {
				Class.forName(SYSData.DB_Driver);
				conn = DriverManager.getConnection(SYSData.DB_URL_HeFan, SYSData.DB_User_HeFan, SYSData.DB_Pass_HeFan);
			}
			//
			else if (database.equals("hefanlottery")) {
				Class.forName(SYSData.DB_Driver);
				conn = DriverManager.getConnection(SYSData.DB_URL_HeFanLottery, SYSData.DB_User_HeFanLottery, SYSData.DB_Pass_HeFanLottery);
			}
			//
			else if (database.equals("hfoms")) {
				Class.forName(SYSData.DB_Driver);
				conn = DriverManager.getConnection(SYSData.DB_URL_hfoms, SYSData.DB_User_hfoms, SYSData.DB_Pass_hfoms);
			}
			//
			else if (database.equals("hefanclub")) {
				Class.forName(SYSData.DB_Driver);
				conn = DriverManager.getConnection(SYSData.DB_URL_HeFanClub, SYSData.DB_User_HeFanClub, SYSData.DB_Pass_HeFanClub);
			}
			//
			else if (database.equals("hibao")) {
				Class.forName(SYSData.DB_Driver);
				conn = DriverManager.getConnection(SYSData.DB_URL_QA, SYSData.DB_User_QA, SYSData.DB_Pass_QA);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void executeSQL(String database, String sql) {
		try {
			connSQL(database);

			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);

			stmt.close();
			// conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static List<Map<String, Object>> getQueryResult(String database, String sql) {
		List<Map<String, Object>> queryResult = new ArrayList<Map<String, Object>>();

		try {
			connSQL(database);

			Statement stmt = conn.createStatement();
			ResultSet resu = stmt.executeQuery(sql);
			ResultSetMetaData resultSetMetaData = resu.getMetaData();

			int columnCount = resultSetMetaData.getColumnCount();
			while (resu.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				for (int i = 1; i <= columnCount; i++) {
					map.put(resultSetMetaData.getColumnName(i), resu.getObject(i));
				}
				queryResult.add(map);
			}

			resu.close();
			stmt.close();
			// conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return queryResult;
	}
}