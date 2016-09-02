package za.co.test;

/**
 * Created by lvika on 2016/09/02.
 */
public class ResultHolder {

    private int qID;
    private String userAnswer;
    private String resultAns;

    public String getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }

    public String getResultAns() {
        return resultAns;
    }

    public void setResultAns(String resultAns) {
        this.resultAns = resultAns;
    }

    public int getqID() {
        return qID;
    }

    public void setqID(int qID) {
        this.qID = qID;
    }
}
