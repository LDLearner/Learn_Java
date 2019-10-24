package Net.SaveWebPic;

import org.apache.log4j.Logger;

/**
 * Created by ld_ab on 2019/9/19.
 */
public class AddLog {
    final static Logger log = Logger.getLogger(AddLog.class);
    public static void addlog(String logstr){
        log.info(logstr);
    }
}
