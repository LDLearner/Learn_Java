package interface_Callback.Timer_test;

/**
 * Created by LD on 2018/11/28.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Timer_test{
    public static void main(String...args){
        ActionListener listener = new TimePrinter();
        Timer t = new Timer(1000, listener);
        t.start();

        JOptionPane.showMessageDialog(null, "Quit?");//弹出对话框，防止主线程结束导致时钟结束
        System.exit(0);
    }
}

class TimePrinter implements ActionListener {
    public void actionPerformed(ActionEvent event) {
        Date now = new Date();
        System.out.println("At the tone,the time is " + now);
        Toolkit.getDefaultToolkit().beep();
    }
}
