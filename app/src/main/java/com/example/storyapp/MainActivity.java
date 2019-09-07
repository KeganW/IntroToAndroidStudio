package com.example.storyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Elements that will be included in the story
    EditText name;
    EditText friend;
    EditText adj;
    EditText age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set event when button "create story" button is clicked
        Button storyMaker = (Button)findViewById(R.id.submitButton);
        storyMaker.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                //Access user inputted elements
                name = (EditText)findViewById(R.id.userName);
                friend = (EditText)findViewById(R.id.userFriendName);
                adj = (EditText)findViewById(R.id.userAdjective);
                age = (EditText)findViewById(R.id.userNumber);

                //Create story object passing in user input
                Story story = new Story(
                        name.getText().toString(),
                        friend.getText().toString(),
                        adj.getText().toString(),
                        age.getText().toString()
                );

                //Check if any of the contents are empty
                if (story.checkEmpty(name) || story.checkEmpty(friend) ||
                        story.checkEmpty(adj) || story.checkEmpty(age)){

                    //Provide user on what to input
                    name.setHint("Name required.");
                    friend.setHint("Friend name required.");
                    adj.setHint("Adjective required.");
                    age.setHint("Age required.");
                    return;

                }

                //String that will hold the whole story
                String storyToTell = story.generateStory();
                //Message object that connects with the story page
                Intent beginIntent = new Intent(getApplicationContext(),
                        SecondActivity.class);
                //Sends information to story page
                beginIntent.putExtra("com.example.storyapp.linkpages",
                        storyToTell);

                startActivity(beginIntent);
            }
        });
    }
}
