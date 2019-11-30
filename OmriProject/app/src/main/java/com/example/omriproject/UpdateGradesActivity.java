package com.example.omriproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class UpdateGradesActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_grades);
        Intent i = getIntent();
    }
}
