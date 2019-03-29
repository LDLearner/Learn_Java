package Hibao_fakeData;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by LD on 2019/3/28.
 */
public class DiffDay {
    public static void main(String[] args) throws ParseException {
        //getDiffDay("2019-03-26","1551888000000");
    }
    public static String dateToStamp(String s) throws ParseException {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = simpleDateFormat.parse(s);
        long ts = date.getTime();
        res = String.valueOf(ts);
        return res;
    }
    public static String stampToDate(String s){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }

    public static int getDiffDay(String runDay,String videoCreateTime) throws ParseException {
        int days=0;
        String runTime=dateToStamp(runDay);
        String videoCreateDay=stampToDate(videoCreateTime);
        if (runDay.equals(videoCreateDay))                  //创建日期为当天的逻辑
        {
            long diff = (Long.parseLong(runTime)-Long.parseLong(videoCreateTime)) / 1000 / 3600;
            if (diff < 1) {
                days = -1000;
            } else if (diff >= 1 && diff < 5) {
                days = -2000;
            } else if (diff >= 5 && diff < 10) {
                days = -3000;
            } else if (diff >= 10 && diff < 24) {
                days = -4000;
            } else {
                System.out.println("diff is error!!!");
            }
            System.out.print("diffHour=" + days + ",");
        } else                                                        //创建日期为非当天的逻辑
        {
            Long aaaaa=Long.parseLong(runTime);
            Long bbbbb=Long.parseLong(videoCreateTime);
            days =(int) ((Long.parseLong(runTime)-Long.parseLong(videoCreateTime)) / (1000 * 3600 * 24) + 1);
            System.out.print("diffDay=" + days + ",");

        }
        return days;

    }
}
