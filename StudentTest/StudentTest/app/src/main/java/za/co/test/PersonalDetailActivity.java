package za.co.test;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PersonalDetailActivity extends AppCompatActivity {

    TextView name ;
    TextView yob;
    TextView street;
    TextView town;
    TextView country;
    TextView postalCode;
    private DBHelper mydb ;
    int id_To_Update = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_detail);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        //getActionBar().setTitle("Personal Details");
        mydb = new DBHelper(this);
        name = (TextView) findViewById(R.id.txtName);
        yob = (TextView) findViewById(R.id.txtYob);
        street = (TextView) findViewById(R.id.txtStreet);
        town = (TextView) findViewById(R.id.txtTown);
        country = (TextView) findViewById(R.id.txtCountry);
        postalCode = (TextView) findViewById(R.id.txtPostalCode);


        mydb = new DBHelper(this);

        Bundle extras = getIntent().getExtras();
        if(extras !=null)
        {
            int Value = extras.getInt("id");

          //  if(Value>0){
                //means this is the view part not the add contact part.
                Cursor rs = mydb.getData(Value);
                id_To_Update = Value;
                rs.moveToFirst();
                if(rs.getCount()>0){
                    String nme = rs.getString(rs.getColumnIndex(DBHelper.P_NAME));
                    String yb = rs.getString(rs.getColumnIndex(DBHelper.P_YEAR_BIRTH));
                    String stret = rs.getString(rs.getColumnIndex(DBHelper.ADDRESS_CODE));
                    String twn = rs.getString(rs.getColumnIndex(DBHelper.ADDRESS_CODE));
                    String counry = rs.getString(rs.getColumnIndex(DBHelper.ADDRESS_CODE));
                    String postalCde = rs.getString(rs.getColumnIndex(DBHelper.ADDRESS_CODE));

                    if (!rs.isClosed())
                    {
                        rs.close();
                    }
                    if(name!=null){
                        Button b = (Button)findViewById(R.id.btnSave);
                        b.setVisibility(View.INVISIBLE);
                    }


                    name.setText((CharSequence)nme);

                    yob.setText((CharSequence)yb);
                }


          // }
        }

        this.setTitle("Personal Details");
    }

    public void saveContact(View view)
    {
        Bundle extras = getIntent().getExtras();
        if(extras !=null)
        {
           // mydb.dropDataBase();
            if(mydb.insertContact(id_To_Update,name.getText().toString(), yob.getText().toString(), null, null, null)){
                Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        }
    }

    public void updateContact(View view)
    {
        Bundle extras = getIntent().getExtras();
        if(extras !=null)
        {
            // mydb.dropDataBase();
            if(mydb.updateContact(1,name.getText().toString(), yob.getText().toString(), null, null, null)){
                Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        }
    }

    public void deleteContact(View view)
    {
        Bundle extras = getIntent().getExtras();
        if(extras !=null)
        {
           //  mydb.dropDataBase();
            mydb.deleteContact();
            //mydb.insertQuestion();
                Toast.makeText(getApplicationContext(), "Deleted", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);

        }
    }



    public void run(View view)
    {
        Bundle extras = getIntent().getExtras();
        if(extras !=null)
        {
            int Value = extras.getInt("id");
            if(Value>0){ //Integer id, String name, String yob, int occupation, int address,int department
                if(mydb.updateContact(id_To_Update,name.getText().toString(), yob.getText().toString(), null, null, null)){
                    Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(), "not Updated", Toast.LENGTH_SHORT).show();
                }
            }
            else{
                if(mydb.insertContact(id_To_Update,name.getText().toString(), yob.getText().toString(), null, null, null)){
                    Toast.makeText(getApplicationContext(), "done", Toast.LENGTH_SHORT).show();
                }

                else{
                    Toast.makeText(getApplicationContext(), "not done", Toast.LENGTH_SHORT).show();
                }
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        }
    }





}
