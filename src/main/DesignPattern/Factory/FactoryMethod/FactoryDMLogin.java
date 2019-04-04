package Factory.FactoryMethod;

/**
 * Created by LD on 2019/4/2.
 */
public class FactoryDMLogin implements Factory {
    public Login createLogin(){
        System.out.println("域名登陆方式");
        return new DomainLogin();
    }
}