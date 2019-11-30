package com.example.omriproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button bt_grade_chart = findViewById(R.id.bt_grade_chart);
        bt_grade_chart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent;
                intent = new Intent(getApplicationContext(), GradeChartActivity.class);
                startActivity(intent);
            }
        });

        final Button bt_update_grades = findViewById(R.id.bt_update_grades);
        bt_update_grades.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(getApplicationContext(), UpdateGradesActivity.class);
                startActivity(intent);            }
        });

        final Button bt_add_profession = findViewById(R.id.bt_add_profession);
        bt_add_profession.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(getApplicationContext(), AddProfessionActivity.class);
                startActivity(intent);            }
        });

        final Button bt_delete_profession = findViewById(R.id.bt_delete_profession);
        bt_delete_profession.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(getApplicationContext(), DeleteProfessionActiviy.class);
                startActivity(intent);            }
        });
    }
}
