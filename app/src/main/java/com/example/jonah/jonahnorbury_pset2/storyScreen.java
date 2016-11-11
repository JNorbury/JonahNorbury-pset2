package com.example.jonah.jonahnorbury_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class storyScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        story is extracted from intent and displayed
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_screen);

        TextView story_place = (TextView) findViewById(R.id.textView4);
        story_place.setText(getIntent().getStringExtra("Story"));
    }

//    button to restart game with same story type
    public void onClickReturnHome(View view) {

        Intent intent = new Intent(this, StartActivity.class);
        startActivity(intent);
        finish();
    }
}
