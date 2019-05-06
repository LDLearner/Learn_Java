package Test.wzn_Hibao;

/**
 * Created by TS on 2017/06/19
 * 用于实现处理时间转换等。如返回指定格式的时间字符串，用于业务中需要输入日期的地方
 * */
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUnit {
	public static void sleepWait(int milliSecond) {
		try {
			Thread.sleep(milliSecond);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getDateCurrent(String format) {
		SimpleDateFormat format2 = new SimpleDateFormat(format);
		Date date = new Date();
		return format2.format(date);
	}
}