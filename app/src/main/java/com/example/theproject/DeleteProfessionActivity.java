package com.example.theproject;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class DeleteProfessionActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    SQLiteDatabase db;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_profession);

        addItemsOnSpinner2();
    }

    public void addItemsOnSpinner2() {

        db = openOrCreateDatabase("profession list", MODE_PRIVATE, null);
        ArrayList<String> lProfession = new ArrayList<String>();
        Cursor cursor = db.rawQuery("select profession from tbl_profession", null);
        Spinner professionSpinner = (Spinner) findViewById(R.id.professionSpinner);

        while (cursor.moveToNext()) {
            lProfession.add(cursor.getString(0));
        }

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, lProfession);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        professionSpinner.setAdapter(dataAdapter);
    }
}
