package Factory.StaticFactory;

/**
 * Created by LD on 2019/4/1.
 * 测试类
 */
public class MainApp {
    public static void main(String[] args) {
//        AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
////        XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("Beans.xml"));
////        HelloWorld h = (HelloWorld) factory.getBean("helloWorld");
//        HelloWorld h = (HelloWorld) context.getBean("helloWorld1");
//        System.out.println(h.getMessage());
//        context.registerShutdownHook();
//        context.close();
        String loginType = "passcode";
        String username = "admin";
        String password ="admin";
        Login login = LoginManager.factory(loginType);
        login.verify(username, password);
    }
}
