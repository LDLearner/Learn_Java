package Factory.FactoryMethod;

/**
 * Created by LD on 2019/4/2.
 */
public class FactoryPWLogin implements Factory {
    public Login createLogin(){
        System.out.println("密码登陆方式");
        return new PasswordLogin();
    }
}
