package com.example.theproject;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class AddProfessionActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    SQLiteDatabase db;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_profession);

        final Button addProfession = findViewById(R.id.btAddProfession);
        addProfession.setOnClickListener(new View.OnClickListener() {
            EditText profession = (EditText) findViewById(R.id.btNewAddProfession);
            EditText grade = (EditText) findViewById(R.id.btGradeAddProfession);
            public void onClick(View v) {
                String professionName = profession.getText().toString();
                int gradeNumber = Integer.parseInt(grade.getText().toString());
                boolean isExist = isFieldExist("tbl_profession",professionName);
                if(0 <= gradeNumber && gradeNumber <= 100 && !isExist) {
                    db = openOrCreateDatabase("profession list new", MODE_PRIVATE, null);
                    db.execSQL("insert into  tbl_profession(profession, grade)" +
                            "values ('"+professionName+"','"+gradeNumber+"')");
                }
            }
        });
    }

    // This method will check if column exists in your table
    public boolean isFieldExist(String tableName, String fieldName)
    {
        boolean isExist = false;
        db = openOrCreateDatabase("profession list new", MODE_PRIVATE, null);
        Cursor res = db.rawQuery("PRAGMA table_info("+tableName+")",null);
        res.moveToFirst();
        do {
            String currentColumn = res.getString(1);
            if (currentColumn.equals(fieldName)) {
                isExist = true;
            }
        } while (res.moveToNext());
        return isExist;
    }
}
