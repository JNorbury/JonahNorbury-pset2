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

import java.io.InputStream;
import java.util.List;

import static android.R.id.list;

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

//        try to reach resources.raw dir and start filestream, else break.
//        story is initiated, words remaining given, hint is set
        try {

            resources = getResources();
            S = new Story(resources.openRawResource(R.raw.madlib1_tarzan));

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

//        if an answer is given, save and clear edittext, move to next placeholder
//        else shout at user
        if (e.getText().length() != 0) {

            S.fillInPlaceholder(e.getText().toString());
            Toast.makeText(this, "good choice!", Toast.LENGTH_SHORT).show();

//            if done, go to next screen (entire story)
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
            Toast.makeText(this, "no word given", Toast.LENGTH_SHORT).show();
        }

    }
}
