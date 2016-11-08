package com.example.jonah.jonahnorbury_pset2;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by jonah on 08-Nov-16.
 */

public class StoryConstructor extends AppCompatActivity {
    private Resources resources;
    private Story S;
    private EditText e;
    private TextView number_words;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.story_layout);
        try {
            resources = getResources();
            InputStream iS = resources.openRawResource(R.raw.madlib0_simple);
            S = new Story(iS);

            number_words = (TextView) findViewById(R.id.textView3);
            number_words.setText(S.getPlaceholderRemainingCount() + " Word(s) left.");

            e = (EditText) findViewById(R.id.editText);
            e.setHint(S.getNextPlaceholder());
        }
        catch (Resources.NotFoundException e) {
            finish();
        }
    }

    public void onClickNewWord(View view) {


        if (e.getText().length() != 0) {
            S.fillInPlaceholder(e.getText().toString());

            if (S.isFilledIn()) {
                Intent getStoryResultScreen = new Intent(this, storyScreen.class);
                getStoryResultScreen.putExtra("Story", S.toString());
                startActivity(getStoryResultScreen);
                finish();
            }
            else {
                e.setText("");
                e.setHint(S.getNextPlaceholder());
                number_words.setText(S.getPlaceholderRemainingCount() + " Word(s) left.");
            }
        }
        else {
            Toast t = Toast.makeText(this, "no word given", Toast.LENGTH_LONG);
            t.show();
        }
    }
}
