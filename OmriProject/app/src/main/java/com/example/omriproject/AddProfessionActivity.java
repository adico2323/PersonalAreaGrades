package com.example.omriproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class AddProfessionActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_profession);
        Intent i = getIntent();
    }
}
