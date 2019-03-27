package Test;

/**
 * Created by LD on 2019/2/28.
 */

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Stocks {
    public static void main(String[] args) throws Exception {
        while (true) {
            Thread.sleep(3000);
            showInfoGroup("大盘");
            showInfoGroup("其它");
            showInfoGroup("铁路");
            showInfoGroup("大盘");
            showInfoGroup("计算机");
            showInfoGroup("医药");
            showInfoGroup("军工");
            showInfoGroup("卫星");
            showInfoGroup("航母");
            showInfoGroup("飞机");
        }
    }

    public static void showInfoGroup(String sharesGroup) {
        if (sharesGroup.equals("大盘")) {
            showHead();
            showInfo("上证指数", "sh000001");
        }
        if (sharesGroup.equals("飞机")) {
            showHead();
            showInfo("中航沈飞", "sh600760");
            showInfo("洪都航空", "sh600316");
            showInfo("中航飞机", "sz000768");
        }
        if (sharesGroup.equals("卫星")) {
            showHead();
            showInfo("航天通信", "sh600677");
            showInfo("北方导航", "sh600435");
        }
        if (sharesGroup.equals("航母")) {
            showHead();
            showInfo("中国重工", "sh601989");
            showInfo("亚星锚链", "sh601890");
        }
        if (sharesGroup.equals("军工")) {
            showHead();
            showInfo("成飞集成", "sz002190");
        }
        if (sharesGroup.equals("铁路")) {
            showHead();
            showInfo("中国中车", "sh601766");
            showInfo("内蒙一机", "sh600967");
        }
        if (sharesGroup.equals("医药")) {
            showHead();
            showInfo("恒瑞医药", "sh600276");
            showInfo("京新药业", "sz002020");
            showInfo("乐普医疗", "sz300003");
            showInfo("美年健康", "sz002044");
        }
        if (sharesGroup.equals("计算机")) {
            showHead();
            showInfo("奇虎软件", "sh601360");
            showInfo("中国软件", "sh600536");
            showInfo("浪潮软件", "sh600756");
            showInfo("浪潮信息", "sz000977");
        }
        if (sharesGroup.equals("其它")) {
            showHead();
            showInfo("东方通信", "sh600776");
        }
    }

    public static void showHead() {
        System.out.println("\n\n----------------------------------------------------------------------");
        System.out.println("股票名称\t" + "成交量百万\t" + "成交金额亿\t" + "昨日收盘\t" + "今日开盘\t" + "今日最低\t" + "今日最高\t" + "当前价格\t" + "涨跌比率\t");
    }

    public static void showInfo(String sharesName, String sharesCode) {
        String sharesStr = getRequest(sharesCode);
        String sharesArr[] = sharesStr.split(",");
        List<String> sharesList = Arrays.asList(sharesArr);

        // 0股票名称、1今日开盘、2昨日收盘、3当前价格、4今日最高、5今日最低、8成交数量(除100后是手数)、9成交金额(除10000后是万)
        List<String> sharesInfoList = new ArrayList<String>();
        sharesInfoList.add(sharesList.get(0).split("\"")[1]);
        sharesInfoList.add(Double.parseDouble(sharesList.get(8)) / 100 / 10000 + "");
        sharesInfoList.add(Double.parseDouble(sharesList.get(9)) / 10000 / 10000 + "");
        sharesInfoList.add(sharesList.get(2));
        sharesInfoList.add(sharesList.get(1));
        sharesInfoList.add(sharesList.get(5));
        sharesInfoList.add(sharesList.get(4));
        sharesInfoList.add(sharesList.get(3));

        System.out.print(sharesInfoList.get(0) + "\t");
        for (int i = 1; i < sharesInfoList.size(); i++) {
            String 价格信息str = sharesInfoList.get(i);
            Double 价格信息dou = Double.parseDouble(价格信息str);

            System.out.print(new DecimalFormat("#0.00").format(价格信息dou) + "\t");
        }

        Double 涨跌比率 = getElevatorRatio(sharesList.get(2), sharesList.get(3));
        System.out.println(new DecimalFormat("0.00").format(涨跌比率) + "%");
    }

    public static Double getElevatorRatio(String price1, String price2) {
        Double priceDouble1 = Double.parseDouble(price1);
        Double priceDouble2 = Double.parseDouble(price2);
        Double 涨跌比率 = ((priceDouble2 / priceDouble1) - 1) * 100;
        涨跌比率 = (double) Math.round(涨跌比率 * 100) / 100;
        return 涨跌比率;
    }

    public static String getRequest(String sharesCode) {
        String requestURL = "http://hq.sinajs.cn/list=" + sharesCode;
        String responseString = "";

        try {
            CloseableHttpClient client = HttpClients.createDefault();
            HttpGet get = new HttpGet(requestURL);

            CloseableHttpResponse response = client.execute(get);
            String responseStatusCode = response.getStatusLine().getStatusCode() + "";

            if (responseStatusCode.equals("200")) {
                HttpEntity responseEntity = response.getEntity();
                responseString = EntityUtils.toString(responseEntity);
            }

            response.close();
            client.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return responseString;
    }
}