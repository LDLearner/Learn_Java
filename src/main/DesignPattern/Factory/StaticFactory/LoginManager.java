package Factory.StaticFactory;

/**
 * Created by LD on 2019/4/1.
 * 登录的工厂类
 */
public class LoginManager {
    public static Login factory( String type ) {
        if ( type.equals("password")) {
            return new PasswordLogin();
        } else if ( type.equals("passcode") ) {
            return new DomainLogin();
        } else {
            throw new RuntimeException("不合法的登录类型");
        }
    }
}