import org.testng.*;
import org.testng.annotations.*;

/**
 * Created by ld_ab on 2019/10/4.
 */
public class LearnTestNG {
    @BeforeClass
    public static void bftest(){
        System.out.println("I'am bftest!");
    }
    @Test
    public static void test1(){
        System.out.println("HI,WORLD!I'am test1!");
    }
    @AfterMethod
    public static void afterClass(ITestResult iTestResult){
        System.out.println("@AfterMethod-方法名称：" + iTestResult.getMethod().getMethodName() + " 执行状态（1-成功，2-失败，3-skip）：" + iTestResult.getStatus());
    }
}
