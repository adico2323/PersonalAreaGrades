package com.example.omriproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class DeleteProfessionActiviy extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete_profession);
        Intent i = getIntent();
    }
}
