package Net.SaveWebPic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by ld_ab on 2019/9/18.
 */
public class GetPic {
    public static void main(String[] args) {
        GetHtml httpC = new GetHtml();
        //GetUrl(httpC.doGet("http://www.j3f4.com/Wznews/51607.html"));
        //51607 to 55395
        for(int i=51701;i<=51720;i++){
            AddLog.addlog("start:"+i+"");
            GetUrl(httpC.doGet("http://www.4sw3.com/Wznews/"+i+".html"));
            AddLog.addlog("-------------------------------------------------------------------------------------------");
        }

    }

    public static void GetUrl(String html) {


        Pattern pattern = Pattern.compile("(http:|https).*?(\\.jpg|2Ejpg)");
        Matcher matcher = pattern.matcher(html);
        SavePic Save=new SavePic();
        while (matcher.find()) {
            if(matcher.group().indexOf("src")==-1){
                AddLog.addlog(matcher.group());
                String collegeId = matcher.group();
                //System.out.println(collegeId);
                Save.saveToFile(collegeId);
            }else{
                String[] splitAddress=matcher.group().split("src=\"");
                AddLog.addlog(splitAddress[1]);
                //System.out.println(splitAddress[1]);
                Save.saveToFile(splitAddress[1]);
            }

        }

    }
}
