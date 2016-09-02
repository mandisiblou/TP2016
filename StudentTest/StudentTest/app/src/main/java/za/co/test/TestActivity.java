package za.co.test;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class TestActivity extends AppCompatActivity {

    private TextView question;
    private TextView option1;
    private TextView option2;
    private TextView option3;
    private TextView answer;
    private TextView userAnswer;
    private ArrayList<QuestionHolder> originalQuestions = new ArrayList<QuestionHolder>();
    private ArrayList<QuestionHolder> answers = new ArrayList<QuestionHolder>();
    private ArrayList<ResultHolder> finalAsn = new ArrayList<ResultHolder>();
    private int count;
    private int size;
    DBHelper dh;
    private QuestionHolder qh;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        question = (TextView) findViewById(R.id.lblQuestion);
        option1 = (TextView) findViewById(R.id.lblOption1);
        option2 = (TextView) findViewById(R.id.lblOption2);
        option3 = (TextView) findViewById(R.id.lblOption3);
        userAnswer = (TextView) findViewById(R.id.txtAnswer);
        dh= new DBHelper(this);
        dh.deleteTest();
        originalQuestions = dh.getAllQuestion();
        size = originalQuestions.size();
        initScreen();
        this.setTitle("Test");
    }

    public void writeTest(View view){
        qh.setUserAnswer(userAnswer.getText().toString());
        answers.add(qh);
        count++;
        initScreen();
    }

    private void initScreen(){

        if(count<size){
            qh = originalQuestions.get(count);
            question.setText((CharSequence)qh.getQuestion());
            option1.setText((CharSequence)qh.getOption1());
            option2.setText((CharSequence)qh.getOption2());
            option3.setText((CharSequence)qh.getOption3());
            userAnswer.setText("");
        }else{
            markTest();
            dh.SaveMark(finalAsn);
            Toast.makeText(getApplicationContext(), "Test Complete", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(),ViewResultsActivity.class);
            startActivity(intent);
        }
    }

    private void markTest(){
        int q= 1;
        for(QuestionHolder holder:answers){
            ResultHolder rh = new ResultHolder();
            rh.setqID(q);
            rh.setUserAnswer(holder.getUserAnswer());
            rh.setResultAns(holder.getAnswer());
            finalAsn.add(rh);
            q++;
        }
    }
}
