package MutilThread.Runnable;

/**
 * Created by LD on 2019/4/4.
 * 因为Runnable方式是对接口的实现，所以采用Runnable方式可以避免Thread方式由于Java单继承带来的缺陷
 * Runnable的代码可以被多个线程共享（Thread实例），适合于多个多个线程处理统一资源的情况
 */
public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (i == 30) {
                Runnable myRunnable = new MyRunnable(); // 创建一个Runnable实现类的对象
                Thread thread1 = new Thread(myRunnable); // 将myRunnable作为Thread target创建新的线程
                Thread thread2 = new Thread(myRunnable);
                Thread thread3 = new Thread(myRunnable);
                Thread thread4 = new Thread(myRunnable);
                thread1.start();  // 调用start()方法使得线程进入就绪状态
                thread2.start();  //等待线程1执行完才开始执行，与main线程并行执行
                thread1.join();  //调用join方法后，调用线程等待该线程完成后，才能继续用下运行，线程1和2并行
                thread3.start();
                thread4.start();
            }
        }
        System.out.println("main线程运行结束！");
    }

}
