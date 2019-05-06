package interface_Callback;

/**
 * Created by LD on 2018/11/28.
 */
public class Teacher implements Callback {

    private Student student;

    public Teacher(Student student) {
        this.student = student;
    }

    public void askQuestion() {
        student.resolveQuestion(this);
    }

    public void tellAnswer(int answer) {
        System.out.println("知道了，你的答案是" + answer);
    }
}
