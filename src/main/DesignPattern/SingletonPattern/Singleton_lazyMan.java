package SingletonPattern;

/**
 * Created by LD on 2019/4/3.
 * 懒汉模式是属于线程不安全的写法。如果多线程同时来进行getInstance的操作，那么这个时候进入if(instance == null)判断时就需要加入线程同步的方法了
 * 懒汉模式的线程安全可以通过“双重检查锁”得以解决
 * “双重检查锁”还解决了直接给类加锁的性能问题，执行步骤如下：
 1.检查变量是否被初始化(不去获得锁)，如果已被初始化则立即返回。
 2.获取锁。
 3.再次检查变量是否已经被初始化，如果还没被初始化就初始化一个对象。
 */
public class Singleton_lazyMan {
    private volatile static Singleton_lazyMan uniqueSingletonLazyMan;   //使用了volatile关键字后，重排序被禁止，所有的写（write）操作都将发生在读（read）操作之前
    private Singleton_lazyMan() {
    }

    public Singleton_lazyMan getInstance() {
        if (null == uniqueSingletonLazyMan) {                  //先判断是否被初始化（此时不去获得锁）
            synchronized (Singleton_lazyMan.class) {            //只有未被初始化时才去获得锁，初始化后均不会时获得锁，解决了性能问题
                if (null == uniqueSingletonLazyMan) {
                    uniqueSingletonLazyMan = new Singleton_lazyMan();
                }
            }
        }
        return uniqueSingletonLazyMan;
    }
}

