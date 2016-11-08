package com.example.jonah.jonahnorbury_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class storyScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_screen);

        Intent intent = getIntent();
        String s = intent.getStringExtra("Story");

        Toast t = Toast.makeText(this, "story loaded" + s, Toast.LENGTH_LONG);
        t.show();

        TextView story_place = (TextView) findViewById(R.id.textView4);
        story_place.setText(s);
    }
}