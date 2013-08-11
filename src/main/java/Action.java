/**
 * Created by mohanraj.nagasamy on 8/11/13.
 */
public class Action {
    private String result = "";
    public void step1() {
        System.out.println("Action.step1");
        result += "step1 ";
    }
    public void step2() {
        System.out.println("Action.step2");
        result += "step2";
    }

    public String result() {
        return result;
    }
}
