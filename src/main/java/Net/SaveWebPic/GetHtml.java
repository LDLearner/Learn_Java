package Net.SaveWebPic;

import org.apache.http.HttpResponse;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by ld_ab on 2019/9/19.
 */
public class GetHtml {
    public static void main(String[] args) {
        doGet("http://www.j3f4.com/Wznews/51607.html");
    }
    public static String doGet(String url) {
        HttpGet get = new HttpGet(url);
        CloseableHttpClient client = HttpClientBuilder.create().build();
//        //开始代理
//        HttpHost proxy = new HttpHost("127.0.0.1", 8888, "http");
//        RequestConfig config = RequestConfig.custom().setProxy(proxy).build();
//        get.setConfig(config);
//        //代理结束

        //修改cookie策略开始
        RequestConfig defaultConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).build();
        get.setConfig(defaultConfig);
        //修改cookie策略结束
        try {
            get.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.81 Safari/537.36");
            HttpResponse response = client.execute(get);
            String res = EntityUtils.toString(response.getEntity());
            //System.out.println(res);
            return res;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "error";
    }

}
