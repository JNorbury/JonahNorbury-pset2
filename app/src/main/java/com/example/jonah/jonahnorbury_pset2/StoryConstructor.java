package com.example.jonah.jonahnorbury_pset2;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by jonah on 08-Nov-16.
 */

public class StoryConstructor extends AppCompatActivity {
    private Resources resources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.story_layout);
        try {
            resources = getResources();
            InputStream iS = resources.openRawResource(R.raw.madlib0_simple);
            Story new_story = new Story(iS);
        }
        catch (Resources.NotFoundException e) {
            Toast toast = Toast.makeText(this, "File: not found!", Toast.LENGTH_LONG);
            toast.show();
        }

    }

}
