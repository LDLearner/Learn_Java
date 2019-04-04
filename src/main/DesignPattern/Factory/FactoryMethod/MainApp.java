package Factory.FactoryMethod;

/**
 * Created by LD on 2019/4/1.
 * 测试类
 */
public class MainApp {
    public static void main(String[] args) throws Exception{
        String loginType = "passcode";
        String username = "admin";
        String password ="admin";
        Factory FactoryPWLogin=(Factory) Class.forName("Factory.FactoryMethod.FactoryPWLogin").newInstance();
        Factory FactoryDMLogin=(Factory) Class.forName("Factory.FactoryMethod.FactoryDMLogin").newInstance();
        Login PWLogin=FactoryPWLogin.createLogin();
        Login DMLogin=FactoryDMLogin.createLogin();
        PWLogin.verify("lidong","123123");
        DMLogin.verify("lidong","123123");
    }
}
