package com.example.omriproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class GradeChartActivity  extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grade_chart);
        Intent i = getIntent();
    }
}
