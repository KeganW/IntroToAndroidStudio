package com.example.storyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        //Ensures that information was passed
        if (getIntent().hasExtra("com.example.storyapp.linkpages")) {

            //Obtain the information that was passed and set that as the new text
            TextView story = (TextView)findViewById(R.id.generatedStory);
            String content = getIntent().getExtras().getString("com.example.storyapp.linkpages");
            story.setText(content);

        }

        //Set an event for the website button, will go to website when clicked
        Button websiteButton = (Button)findViewById(R.id.myWebsite);
        websiteButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String personalWebsite = "https://keganw.github.io/KegansWebsite/";
                //creates Uri object to be used as a reference by intent
                Uri webAddress = Uri.parse(personalWebsite);
                //prepare to launch activity (go to website)
                Intent goWebsite = new Intent(Intent.ACTION_VIEW, webAddress);

                //checks for validity
                if (goWebsite.resolveActivity(getPackageManager()) != null){
                    startActivity(goWebsite);
                }
            }
        });
    }
}