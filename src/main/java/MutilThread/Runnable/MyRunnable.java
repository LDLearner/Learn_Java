package MutilThread.Runnable;

/**
 * Created by LD on 2019/4/4.
 */
public class MyRunnable implements Runnable {
    private int i = 0;
    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName()+"线程3秒后开始执行...");
            Thread.sleep(3000);                                         //当前线程睡眠3秒，不影响其它线程的执行，sleep不释放锁
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //synchronized (this) {
            for (i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        //}
    }
}