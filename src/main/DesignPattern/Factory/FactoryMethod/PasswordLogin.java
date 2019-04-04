package Factory.FactoryMethod;

/**
 * Created by LD on 2019/4/1.
 */

public class PasswordLogin implements Login {

    @Override
    public boolean verify(String username, String password) {
        // TODO Auto-generated method stub
        //业务逻辑
        System.out.println("Login through password!");
        return true;
    }

}