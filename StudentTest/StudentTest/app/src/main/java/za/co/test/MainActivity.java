package za.co.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {


    //DBHelper mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // mydb = new DBHelper(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        super.onOptionsItemSelected(item);

        switch(item.getItemId())
        {
            case R.id.item1:Bundle dataBundle = new Bundle();
                dataBundle.putInt("id", 0);

                Intent intent = new Intent(getApplicationContext(),PersonalDetailActivity.class);
                intent.putExtras(dataBundle);

                startActivity(intent);
                return true;
            case R.id.item2:Bundle dataBundle2 = new Bundle();
                dataBundle2.putInt("id", 1);

                Intent intent2 = new Intent(getApplicationContext(),TestActivity.class);
                intent2.putExtras(dataBundle2);

                startActivity(intent2);
                return true;
            case R.id.item3:Bundle dataBundle3 = new Bundle();
                dataBundle3.putInt("id", 1);

                Intent intent3 = new Intent(getApplicationContext(),ViewResultsActivity.class);
                intent3.putExtras(dataBundle3);

                startActivity(intent3);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
