package za.co.test;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "STUDENT_TEST.db";
    public static final String P_NAME = "P_NAME";
    public static final String P_YEAR_BIRTH = "P_YEAR_BIRTH";
    public static final String OCCUPATION_CODE= "OCCUPATION_CODE";
    public static final String ADDRESS_CODE = "ADDRESS_CODE";
    public static final String DEPARTMENT_CODE = "DEPARTMENT_CODE";


    public static final String QUESTION_CODE = "QUESTION_CODE";
    public static final String QUESTION = "QUESTION";
    public static final String QUESTION_OPTION1 = "QUESTION_OPTION1" ;
    public static final String QUESTION_OPTION2 = "QUESTION_OPTION2" ;
    public static final String QUESTION_OPTION3 = "QUESTION_OPTION3";
    public static final String QUESTION_ANSWER = "QUESTION_ANSWER" ;


    private Context context;
    public DBHelper(Context context)
    {
        super(context, DATABASE_NAME , null, 1);
        this.context=context;
        SQLiteDatabase db = this.getWritableDatabase();
        onCreate(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS TBL_OCCUPATION");
        db.execSQL("DROP DATABASE IF EXISTS STUDENT_TEST");
        //onCreate(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub

        db.execSQL(
                "CREATE TABLE IF NOT EXISTS TBL_OCCUPATION\n" +
                        "(\n" +
                        "\tOCCUPATION_CODE INT UNIQUE,\n" +
                        "\tOCCUPATION_DESCRIPTION VARCHAR(30),\n" +
                        "\tPRIMARY KEY(OCCUPATION_CODE)\n" +
                        ")"
        );

        db.execSQL(
                "CREATE  TABLE IF NOT EXISTS TBL_ADDRESS\n" +
                        "(\n" +
                        "\tADDRESS_CODE INT UNIQUE,\n" +
                        "\tADDRESS_STREET VARCHAR(30),\n" +
                        "\tADDRESS_TOWN VARCHAR(30),\n" +
                        "\tADDRESS_TOWN_CODE VARCHAR(10),\n" +
                        "\tADDRESS_COUNTRY VARCHAR(30),\n" +
                        "\tPRIMARY KEY(ADDRESS_CODE)\n" +
                        ")"
        );

        db.execSQL(
                "CREATE  TABLE IF NOT EXISTS TBL_DEPARTMENT\n" +
                        "(\n" +
                        "\tDEPARTMENT_CODE INT UNIQUE,\n" +
                        "\tNAME VARCHAR(30),\n" +
                        "\tPRIMARY KEY(DEPARTMENT_CODE)\n" +
                        ")"
        );

        db.execSQL(
                "CREATE  TABLE IF NOT EXISTS TBL_QUESTION\n" +
                        "(\n" +
                        "\tQUESTION_CODE INT UNIQUE,\n" +
                        "\tQUESTION_ VARCHAR(30),\n" +
                        "\tQUESTION_OPTION1 VARCHAR(30),\n" +
                        "\tQUESTION_OPTION2 VARCHAR(30),\n" +
                        "\tQUESTION_OPTION3 VARCHAR(30),\n" +
                        "\tQUESTION_ANSWER VARCHAR(30),\n" +
                        "\tPRIMARY KEY(QUESTION_CODE)\n" +
                        ")"
        );

        db.execSQL(
                "CREATE  TABLE IF NOT EXISTS TBL_PESRONAL_DETAILS\n" +
                        "(\n" +
                        "\tP_CODE INT UNIQUE,\n" +
                        "\tP_NAME VARCHAR(30),\n" +
                        "\tP_YEAR_BIRTH VARCHAR(30),\n" +
                        "\tOCCUPATION_CODE INT,\n" +
                        "\tADDRESS_CODE INT,\n" +
                        "\tDEPARTMENT_CODE INT,\n" +
                        "\tPRIMARY KEY(P_CODE),\n" +
                        "\tFOREIGN KEY(OCCUPATION_CODE) REFERENCES TBL_OCCUPATION(OCCUPATION_CODE),\n" +
                        "\tFOREIGN KEY(ADDRESS_CODE) REFERENCES TBL_ADDRESS(ADDRESS_CODE),\n" +
                        "\tFOREIGN KEY(DEPARTMENT_CODE) REFERENCES TBL_DEPARTMENT(DEPARTMENT_CODE)\n" +
                        ")"
        );

        db.execSQL(
                "CREATE  TABLE IF NOT EXISTS TBL_RESULTS\n" +
                        "(\n" +
                        "\tRESULTS_CODE INT UNIQUE,\n" +
                        "\tQUESTION_CODE INT,\n" +
                        "\tQUESTION_ANSWER VARCHAR(30),\n" +
                        "\tRESULTS_ANSWER VARCHAR(30),\n" +
                        "\tPRIMARY KEY(RESULTS_CODE),\n" +
                        "\tFOREIGN KEY(QUESTION_CODE) REFERENCES TBL_QUESTION(QUESTION_CODE)\n" +
                        ")"
        );

        db.execSQL(
                "CREATE  TABLE IF NOT EXISTS TBL_RESULTS\n" +
                        "(\n" +
                        "\tRESULTS_CODE INT UNIQUE,\n" +
                        "\tQUESTION_CODE INT,\n" +
                        "\tQUESTION_ANSWER VARCHAR(30),\n" +
                        "\tRESULTS_ANSWER VARCHAR(30),\n" +
                        "\tPRIMARY KEY(RESULTS_CODE),\n" +
                        "\tFOREIGN KEY(QUESTION_CODE) REFERENCES TBL_QUESTION(QUESTION_CODE)\n" +
                        "\t\n" +
                        "\t\n" +
                        ")"
        );
       // insertQuestion();
    }

    public void dropDataBase(){
        //SQLiteDatabase db = this.getWritableDatabase();
        //db.execSQL("DROP TABLE TBL_QUESTION");
        //this.context.deleteDatabase("STUDENT_TEST");
       // System.out.println("Deleted");
    }

    public boolean insertQuestion  ()
    {

        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("TBL_QUESTION",null,null);
        ContentValues contentValues = new ContentValues();
        contentValues.put("QUESTION_CODE", 1);
        contentValues.put("QUESTION_", "Which rule is considered the most important RULE OF THE ROAD in S.A?");
        contentValues.put("QUESTION_OPTION1", "A. Always be courteous and considerate towards fellow road users.");
        contentValues.put("QUESTION_OPTION2", "B. Do't exceed the speed limit");
        contentValues.put("QUESTION_OPTION3", "C. Keep to the left side of the road far as is safe");
        contentValues.put("QUESTION_ANSWER", "A");
        db.insert("TBL_QUESTION", null, contentValues);


        contentValues = new ContentValues();
        contentValues.put("QUESTION_CODE", 2);
        contentValues.put("QUESTION_", "The furthest that your vehicle's dim lights may shine in front of you..m?");
        contentValues.put("QUESTION_OPTION1", "A. 45");
        contentValues.put("QUESTION_OPTION2", "B. 100");
        contentValues.put("QUESTION_OPTION3", "C. 150");
        contentValues.put("QUESTION_ANSWER", "A");
        db.insert("TBL_QUESTION", null, contentValues);

        contentValues = new ContentValues();
        contentValues.put("QUESTION_CODE", 3);
        contentValues.put("QUESTION_", "If you want to change lanes, you must..");
        contentValues.put("QUESTION_OPTION1", "A. Switch on your indicator and change lanes");
        contentValues.put("QUESTION_OPTION2", "B. Give the neccesary signal and after looking for other traffic, change lanes.");
        contentValues.put("QUESTION_OPTION3", "C. Apply the brakes lightly and then change lanes");
        contentValues.put("QUESTION_ANSWER", "B");
        db.insert("TBL_QUESTION", null, contentValues);

        contentValues = new ContentValues();
        contentValues.put("QUESTION_CODE", 4);
        contentValues.put("QUESTION_", "Sign R1 shows you that the road?");
        contentValues.put("QUESTION_OPTION1", "A. Winds");
        contentValues.put("QUESTION_OPTION2", "B. Is untarred");
        contentValues.put("QUESTION_OPTION3", "C. Is slippery");
        contentValues.put("QUESTION_ANSWER", "C");
        db.insert("TBL_QUESTION", null, contentValues);

        contentValues = new ContentValues();
        contentValues.put("QUESTION_CODE", 5);
        contentValues.put("QUESTION_", "Vehicle of which the brakes are not good, must be towed...");
        contentValues.put("QUESTION_OPTION1", "A. With a rope");
        contentValues.put("QUESTION_OPTION2", "B. With a tow-bar");
        contentValues.put("QUESTION_OPTION3", "C. On a trailer");
        contentValues.put("QUESTION_ANSWER", "B");
        db.insert("TBL_QUESTION", null, contentValues);

        return true;
    }

    public boolean insertContact  (Integer id, String name, String yob, Integer occupation, Integer address,Integer department)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("P_CODE", 1);
        contentValues.put("P_NAME", name);
        contentValues.put("P_YEAR_BIRTH", yob);
        contentValues.put("OCCUPATION_CODE", occupation);
        contentValues.put("ADDRESS_CODE", address);
        contentValues.put("DEPARTMENT_CODE", department);
        db.insert("TBL_PESRONAL_DETAILS", null, contentValues);
        //db.update("TBL_PESRONAL_DETAILS", contentValues, "id = ? ", new String[] { Integer.toString(id) } );
        return true;
    }

    public boolean updateContact (Integer id, String name, String yob, Integer occupation, Integer address,Integer department)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("P_NAME", name);
        contentValues.put("P_YEAR_BIRTH", yob);
        contentValues.put("OCCUPATION_CODE", occupation);
        contentValues.put("ADDRESS_CODE", address);
        contentValues.put("DEPARTMENT_CODE", department);
        db.update("TBL_PESRONAL_DETAILS", contentValues, "P_CODE = ? ", new String[] { Integer.toString(id) } );
        return true;
    }   public Cursor getData(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from TBL_PESRONAL_DETAILS", null );
        return res;
    }



    public Integer deleteContact ()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("TBL_PESRONAL_DETAILS",null,null);
    }

    public Integer deleteTest ()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("TBL_RESULTS",null,null);
    }

    public ArrayList<QuestionHolder> getAllQuestion()
    {
        ArrayList<QuestionHolder> array_list = new ArrayList<QuestionHolder>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from TBL_QUESTION", null );
        res.moveToFirst();
        int count = res.getCount();
        while(res.isAfterLast() == false){
            QuestionHolder qh = new QuestionHolder();
            qh.setQuestion(res.getString(1));
            qh.setOption1(res.getString(2));
            qh.setOption2(res.getString(3));
            qh.setOption3(res.getString(4));
            qh.setAnswer(res.getString(5));
            array_list.add(qh);
            res.moveToNext();
        }
        return array_list;
    }

    public ArrayList<ResultHolder> getResults()
    {
        ArrayList<ResultHolder> array_list = new ArrayList<ResultHolder>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from TBL_RESULTS", null );
        res.moveToFirst();
        int count = res.getCount();
        while(res.isAfterLast() == false){
            ResultHolder rh = new ResultHolder();
            rh.setqID(res.getInt(1));
            rh.setResultAns(res.getString(2));
            rh.setUserAnswer(res.getString(3));
            array_list.add(rh);
            res.moveToNext();
        }
        return array_list;
    }

    public boolean SaveMark(ArrayList<ResultHolder> finalResult)
    {
        for(ResultHolder rh :finalResult){
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("QUESTION_CODE", rh.getqID());
            contentValues.put("QUESTION_ANSWER", rh.getResultAns());
            contentValues.put("RESULTS_ANSWER", rh.getUserAnswer());
            db.insert("TBL_RESULTS", null, contentValues);
        }

        //db.update("TBL_PESRONAL_DETAILS", contentValues, "id = ? ", new String[] { Integer.toString(id) } );
        return true;
    }

}