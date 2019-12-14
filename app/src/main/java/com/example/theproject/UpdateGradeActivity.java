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

public class UpdateGradeActivity extends Activity {
    /**
     * Called when the activity is first created.
     */

    SQLiteDatabase db;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_grades);

        addItemsOnUpdateSpinner();

        final Button updateProfession = findViewById(R.id.btUpdateGrades);
        updateProfession.setOnClickListener(new View.OnClickListener() {
            Spinner professionSpinner = (Spinner) findViewById(R.id.professionSpinnerUpdate);
            EditText grade = (EditText) findViewById(R.id.etGradeAddProfession);
            public void onClick(View v) {
                String profession = professionSpinner.getSelectedItem().toString();
                int gradeNumber = Integer.parseInt(grade.getText().toString());
                if(0 <= gradeNumber && gradeNumber <= 100) {
                    db = openOrCreateDatabase("profession list new", MODE_PRIVATE, null);
                    db.execSQL("update tbl_profession set grade='" +
                            gradeNumber +
                            "' where profession='" + profession + "'");
                }
            }
        });
    }

    public void addItemsOnUpdateSpinner() {

        db = openOrCreateDatabase("profession list new", MODE_PRIVATE, null);
        ArrayList<String> lProfession = new ArrayList<String>();
        Cursor cursor = db.rawQuery("select profession from tbl_profession", null);
        Spinner professionSpinner = (Spinner) findViewById(R.id.professionSpinnerUpdate);

        while (cursor.moveToNext()) {
            lProfession.add(cursor.getString(0));
        }

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, lProfession);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        professionSpinner.setAdapter(dataAdapter);
    }
}
