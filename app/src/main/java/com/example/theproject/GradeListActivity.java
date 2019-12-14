package com.example.theproject;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class GradeListActivity extends Activity {
    /**
     * Called when the activity is first created.
     */

    SQLiteDatabase db;
    List<Profession> professionList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grades_list);

        getGradeList();
    }

    private void getGradeList()
    {
        db = openOrCreateDatabase("profession list new", MODE_PRIVATE, null);
        Cursor cursor = db.rawQuery("select * from tbl_profession", null);
        ListView gradeList = (ListView) findViewById(R.id.gradeList);

        professionList = new ArrayList<Profession>();

        while (cursor.moveToNext()) {
            String professionName = cursor.getString(0);
            int professionGrade = cursor.getInt(1);
            Profession tmpProfession = new Profession(professionName, professionGrade);
            professionList.add(tmpProfession);
        }

        ArrayAdapter adapter;
        adapter = new ArrayAdapter<Profession>(this,
                R.layout.activity_listview, professionList);

        ListView listView = (ListView) findViewById(R.id.gradeList);
        listView.setAdapter(adapter);
    }
}
