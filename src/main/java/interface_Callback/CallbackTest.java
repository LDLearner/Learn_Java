package interface_Callback;

/**
 * Created by LD on 2018/11/28.
 */
public class CallbackTest {
    public void testCallback () {
        Student student = new Ricky();
        Teacher teacher = new Teacher(student);
        teacher.askQuestion();
    }
    public static void main(String args[]) {
        CallbackTest T=new CallbackTest();
        T.testCallback();
    }
}
