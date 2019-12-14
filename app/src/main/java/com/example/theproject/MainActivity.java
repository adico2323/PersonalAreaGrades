package com.example.theproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db;
    List<Profession> ProfessionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buildTables();
        if(!checkInitTables()) {
            initTables();
        }

        final Button gradeList = findViewById(R.id.btGradeList);
        gradeList.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(getBaseContext(), GradeListActivity.class);
                startActivity(myIntent);
            }
        });

        final Button updateGrades = findViewById(R.id.btUpdateGrades);
        updateGrades.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(getBaseContext(), UpdateGradeActivity.class);
                startActivity(myIntent);
            }
        });

        final Button addProfession = findViewById(R.id.btAddProfession);
        addProfession.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(getBaseContext(), AddProfessionActivity.class);
                startActivity(myIntent);
            }
        });

        final Button deleteProfession = findViewById(R.id.btDeleteProfession);
        deleteProfession.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(getBaseContext(), DeleteProfessionActivity.class);
                startActivity(myIntent);
            }
        });
    }

    private void buildTables() {
        db = openOrCreateDatabase("profession list new", MODE_PRIVATE, null);
        db.execSQL("create table if not exists  tbl_profession(profession text, grade int) ");
    }

    private void initTables() {
        db = openOrCreateDatabase("profession list new", MODE_PRIVATE, null);

        Profession p1 =new Profession("math", 90);
        Profession p2 =new Profession("english", 80);
        Profession p3 =new Profession("literature", 70);
        Profession p4 =new Profession("computers", 75);
        Profession p5 =new Profession("arabic", 100);

        ProfessionList = new ArrayList<Profession>();
        ProfessionList.add(p1);
        ProfessionList.add(p2);
        ProfessionList.add(p3);
        ProfessionList.add(p4);
        ProfessionList.add(p5);

        for(int i=0; i<ProfessionList.size(); i++){

            db.execSQL("insert into tbl_profession values('"+ProfessionList.get(i).getProfession()+
                    "', '"+ProfessionList.get(i).getGrade() + "')");
        }
    }

    private boolean checkInitTables(){
        db = openOrCreateDatabase("profession list new", MODE_PRIVATE, null);
        Cursor cursor = db.rawQuery("select profession from tbl_profession", null);
        boolean tableHasData = false;

        while (cursor.moveToNext())
        {
            tableHasData = true;
        }

        return tableHasData;
    }
}
