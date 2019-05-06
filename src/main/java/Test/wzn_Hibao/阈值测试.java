package Test.wzn_Hibao;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class 阈值测试 {

	public static void main(String[] args) throws Exception {
		long startTime=System.currentTimeMillis();   //获取开始时间
		Test01("F:\\TestJava\\123.txt", "2019-03-26");
		long endTime=System.currentTimeMillis(); //获取结束时间
		System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
	}

	public static void Test01(String logPath, String logDate) throws Exception {
		// 文件对象
		InputStream inputStream = new FileInputStream(logPath);
		Reader reader = new InputStreamReader(inputStream);
		BufferedReader bufferedReader = new BufferedReader(reader);

		// 执行行号
		int i = 1;
		// 读取文件
		String line = "";
		while ((line = bufferedReader.readLine()) != null) {
			// 处理数据
			line = line.replace("videoId = ", "videoId=");
			line = line.substring(line.indexOf("videoId"), line.length() - 2);

			// 只读取信息行
			if (line.contains("videoId")) {
				// 分隔行内容，并得到相应字段的值
				String[] arr = line.split(",");
				String videoId = arr[0].toString().split("=")[1];
				int category = Integer.parseInt(arr[1].toString().split(":")[1]);
				String group = arr[2].toString().split(":")[1];
				// String time = arr[3].toString().split(":", 2)[1];
				int view = Integer.parseInt(arr[4].toString().split(":")[1]);
				int share = Integer.parseInt(arr[5].toString().split(":")[1]);
				int collect = Integer.parseInt(arr[6].toString().split(":")[1]);
				int comment = Integer.parseInt(arr[7].toString().split(":")[1]);
				int watch = Integer.parseInt(arr[8].toString().split(":")[1]);

				// 根据videoId查询数据库，得到日期
				List<Map<String, Object>> queryResult = JDBC.getQueryResult("hibao", "select create_time from hi_video where id=" + videoId);
				String createTime = queryResult.get(0).get("create_time").toString();
				String createTime时间 = createTime.substring(0, 19);
				String createTime天数 = createTime.substring(0, 10);

				// 计算查询日期与本地日期的相隔天数(查询日期1号，本地日期6号，相隔天数为6)，如果小于1天，计算相隔小时
				int days = getDayByBetween("yyyy-MM-dd", createTime天数, logDate) + 1;

				// 判断相隔日期与分类+字母
				if (days == 1) {
					double hour = getHourByBetween("yyyy-MM-dd HH:mm:ss", createTime时间, logDate + " 24:00:00");

					if (category == 1 && hour < 1 && 阈值数据.一类1天小于01小时.contains(group)) {

					} else if (category == 1 && hour > 1 && hour < 5 && 阈值数据.一类1天小于05小时.contains(group)) {

					} else if (category == 1 && hour > 5 && hour < 10 && 阈值数据.一类1天小于10小时.contains(group)) {

					} else if (category == 1 && hour > 10 && hour < 24 && 阈值数据.一类1天小于24小时.contains(group)) {

					} else if (category == 2 && hour < 1 && 阈值数据.二类1天小于01小时.contains(group)) {

					} else if (category == 2 && hour > 1 && hour < 5 && 阈值数据.二类1天小于05小时.contains(group)) {

					} else if (category == 2 && hour > 5 && hour < 10 && 阈值数据.二类1天小于10小时.contains(group)) {

					} else if (category == 2 && hour > 10 && hour < 24 && 阈值数据.二类1天小于24小时.contains(group)) {

					} else {
						System.out.println("----------相隔小时与分类+字母错误----------" + videoId);
					}
				} else if (days == 2 && category == 1 && 阈值数据.一类2天.contains(group)) {

				} else if (days == 2 && category == 2 && 阈值数据.二类2天.contains(group)) {

				} else if (days == 3 && category == 1 && 阈值数据.一类3天.contains(group)) {

				} else if (days == 3 && category == 2 && 阈值数据.二类3天.contains(group)) {

				} else if (days == 4 && category == 1 && 阈值数据.一类4天.contains(group)) {

				} else if (days == 4 && category == 2 && 阈值数据.二类4天.contains(group)) {

				} else if (days == 5 && category == 1 && 阈值数据.一类5天.contains(group)) {

				} else if (days == 5 && category == 2 && 阈值数据.二类5天.contains(group)) {

				} else if (days == 6 && category == 1 && 阈值数据.一类6天.contains(group)) {

				} else if (days == 6 && category == 2 && 阈值数据.二类6天.contains(group)) {

				} else if (days == 7 && category == 1 && 阈值数据.一类7天.contains(group)) {

				} else if (days == 7 && category == 2 && 阈值数据.二类7天.contains(group)) {

				} else if (days >= 8 && days <= 14 && category == 1 && 阈值数据.一类2周.contains(group)) {

				} else if (days >= 8 && days <= 14 && category == 2 && 阈值数据.二类2周.contains(group)) {

				} else if (days >= 15 && days <= 21 && category == 1 && 阈值数据.一类3周.contains(group)) {

				} else if (days >= 15 && days <= 21 && category == 2 && 阈值数据.二类3周.contains(group)) {

				} else if (days >= 22 && days <= 28 && category == 1 && 阈值数据.一类4周.contains(group)) {

				} else if (days >= 22 && days <= 28 && category == 2 && 阈值数据.二类4周.contains(group)) {

				} else if (days >= 29 && days <= 35 && category == 1 && 阈值数据.一类5周.contains(group)) {

				} else if (days >= 29 && days <= 35 && category == 2 && 阈值数据.二类5周.contains(group)) {

				} else if (days >= 36 && days <= 42 && category == 1 && 阈值数据.一类6周.contains(group)) {

				} else if (days >= 36 && days <= 42 && category == 2 && 阈值数据.二类6周.contains(group)) {

				} else if (days >= 43 && category == 1 && 阈值数据.一类7周.contains(group)) {

				} else if (days >= 43 && category == 2 && 阈值数据.二类7周.contains(group)) {

				} else {
					System.out.println("----------相隔日期与分类+字母错误----------" + videoId);
				}

				// 判断分类category
				// 判断分组group：有5%的概率是G、85%的概率是H、5%的概率是I、5%的概率是J
				// 播放view、评论comment、收藏collect、分享share、粉丝watch
				阈值判断.fun(group, "播放", view, videoId);
				阈值判断.fun(group, "评论", comment, videoId);
				阈值判断.fun(group, "收藏", collect, videoId);
				阈值判断.fun(group, "分享", share, videoId);
				阈值判断.fun(group, "粉丝", watch, videoId);
			}

			System.out.println("执行行数" + i++);
		}

		System.out.println("-----结束执行-----");
	}

	/** 返回本地日期 */
	public static String getDateByLocal(String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date date = new Date();
		return sdf.format(date);
	}

	/** 返回间隔小时(余取小时，放弃天数) */
	public static double getHourByBetween(String format, String startDate, String endDate) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date d1 = sdf.parse(startDate);
		Date d2 = sdf.parse(endDate);
		// getTime返回毫秒，1000毫秒=1秒、返回相隔小时
		double diffHour = (double) (d2.getTime() - d1.getTime()) / (1000 * 60 * 60);

		// 大于24小时，取余
		if (diffHour > 24) {
			diffHour = diffHour % 24;
		}

		return diffHour;
	}

	/** 返回间隔天数 */
	public static int getDayByBetween(String format, String startDate, String endDate) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date d1 = null, d2 = null;
		try {
			d1 = sdf.parse(startDate);
			d2 = sdf.parse(endDate);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// getTime返回毫秒，1000毫秒=1秒、返回相隔天数
		int diffDay = (int) (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24);

		return diffDay;
	}

}