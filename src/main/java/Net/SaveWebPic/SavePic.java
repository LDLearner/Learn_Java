package Net.SaveWebPic;

/**
 * Created by ld_ab on 2019/9/19.
 */
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SavePic {
    public void saveToFile(String destUrl) {
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        HttpURLConnection httpUrl = null;
        URL url = null;
        int BUFFER_SIZE = 1024;
        byte[] buf = new byte[BUFFER_SIZE];
        int size = 0;
        try {
            url = new URL(destUrl);
            httpUrl = (HttpURLConnection) url.openConnection();
            httpUrl.connect();
            bis = new BufferedInputStream(httpUrl.getInputStream());
            fos = new FileOutputStream("E:\\Tools\\Pic\\"+getfilename()+".jpg");
            while ((size = bis.read(buf)) != -1) {
                fos.write(buf, 0, size);
            }
            fos.flush();
        } catch (IOException e) {
        } catch (ClassCastException e) {
        } catch (Exception e) {
        }finally {
            try {
                fos.close();
                bis.close();
                httpUrl.disconnect();
            } catch (IOException e) {
            } catch (NullPointerException e) {
            }
        }
    }

    public static String getfilename(){
        String res=null;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        //System.out.println(df.format(new Date()));
        res=df.format(new Date())+"_"+String.valueOf(System.currentTimeMillis());
        return res;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SavePic dw=new SavePic();
        dw.saveToFile("https://cp1.douguo.com/upload/caiku/e/f/9/220_ef1b8a39fa93c683e9328ae0d82bf289.jpg");
        //System.out.println(getfilename());

    }
}
