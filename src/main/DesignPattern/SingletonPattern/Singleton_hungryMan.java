package SingletonPattern;

/**
 * Created by LD on 2019/4/3.
 * 饿汉式单例模式，本身是一种线程安全的方法，再类创建的时候，对象就生成了，所以不存在线程同步的问题。
 */
public class Singleton_hungryMan {

    private static Singleton_hungryMan instance = new Singleton_hungryMan();
    private Singleton_hungryMan(){
    }
    public Singleton_hungryMan getInstance(){
        return instance;
    }

}
