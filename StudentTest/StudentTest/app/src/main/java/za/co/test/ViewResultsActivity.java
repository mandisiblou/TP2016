package za.co.test;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.ArrayList;

public class ViewResultsActivity extends AppCompatActivity {


    private DBHelper mydb ;

    private TextView name;
    private TextView totalMark;
    private TextView obtainedMark;
    private TextView percentage;
    private TextView status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_results);

        mydb = new DBHelper(this);
        name = (TextView) findViewById(R.id.txtName);
        totalMark = (TextView) findViewById(R.id.txtTotalMark);
        obtainedMark = (TextView) findViewById(R.id.txtObtainedMark);
        percentage = (TextView) findViewById(R.id.txtPercentage);
        status = (TextView) findViewById(R.id.txtStatus);

        this.setTitle("Results");

        mydb = new DBHelper(this);

        Bundle extras = getIntent().getExtras();
       // if(extras !=null)
       // {
          //  int Value = extras.getInt("id");

            //  if(Value>0){
            //means this is the view part not the add contact part.
            ArrayList<ResultHolder> results =  mydb.getResults();

            int oMark=0;
            BigDecimal perc;
            String stat="pass";

            for(ResultHolder result :results){
                if(result.getResultAns()!=null && result.getUserAnswer()!=null ){
                    if(result.getResultAns().toUpperCase().equals(result.getUserAnswer().toUpperCase())){
                        oMark = oMark+1;
                    }
                }

            }
           // BigDecimal dec = new BigDecimal(oMark/5)*100;
            perc = (new BigDecimal(oMark).divide(new BigDecimal(5))).multiply(new BigDecimal(100));
            if(perc.compareTo(new BigDecimal(50))<1){
                stat = "fail";
            }

            name.setText((CharSequence)"Test");
            totalMark.setText((CharSequence)String.valueOf(5));
            obtainedMark.setText((CharSequence)String.valueOf(oMark));
            percentage.setText((CharSequence)String.valueOf(perc));
            status.setText((CharSequence)String.valueOf(stat));




     //   }
    }
}
