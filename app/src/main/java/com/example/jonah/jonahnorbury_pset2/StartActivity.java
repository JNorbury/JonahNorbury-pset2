package com.example.jonah.jonahnorbury_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

    }

//    button starts story constructor
    public void onClickButtonStart(View view) {

        startActivity(new Intent(this, StoryConstructor.class));
        finish();

    }
}
