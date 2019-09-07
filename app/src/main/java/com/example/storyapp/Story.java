package com.example.storyapp;
import android.widget.EditText;
import java.util.Random;


public class Story {

    //object used to generate random index
    private Random rand = new Random();
    //characteristics used in story, defined by user
    private String name;
    private String friendName;
    private String adjective;
    private String age;


    //constructor
    public Story(String name, String friendName, String adjective, String age){

        this.name = name;
        this.friendName = friendName;
        this.adjective = adjective;
        this.age = age;

    }

    //checks if user input is empty
    protected boolean checkEmpty(EditText input) {

        return input.getText().toString().trim().length() == 0;

    }

    //creates a story based on user input, picks randomly
    protected String generateStory(){

        //beginning of story, four intros total
         String[] INTROS = {
                "Once upon a time there was a person named " + name +
                " who had a friend named " + friendName + ".",


                "A long time ago, there was a kid named " + name +
                " who had a friend named " + friendName + ".",


                "According to legend, there was a powerful being " +
                "named " + name + " whose equal was " + friendName + ".",

                "There was a time when a hero named " + name +
                " had a sidekick who was called " + friendName + "."
         };


        //main chunk of story, four stories total
         String[] RISING_ACTIONS = {

                 "One day, they saw a dark cave and entered it. They saw " +
                 "glowing eyes, and it started to charge straight towards " +
                 "them! And behold, there was a mighty baby dragon. Just " +
                 "when all hope was lost, the baby dragon licked them. " +
                 "What a journey for a " + age + " year old. One word to " +
                 "describe this adventure by many scholars: " + adjective,

                 "One night, they saw a haunted house and decided to " +
                 "explore it. Just as they entered, the door shut tight. " +
                 "They quickly tried to exit, but they could not. In fear, " +
                 "they each grabbed a sharp rod near the door. Within " +
                 "seconds, loud growling could be heard, approaching them " +
                 "in a steady pace. Desperate, they looked around to find a " +
                 adjective +  " window. Both used the sharp rod to break " +
                 "it, and jumped out. Lucky for the " + age + " year olds, " +
                 "they did not become its next meal.",


                 "Each had their own kingdom, and times were getting rough. " +
                 "During Winter, both kingdoms were running low on food. In " +
                 "order to feed their people, both had no choice but to look" +
                 " at the neighboring kingdom. Both happened to run into " +
                 "each other in the midst of a storm. Each knew what was " +
                 "about to happen, but just before anything could, a "  +
                 "rainbow appeared and the storm ceased. A new, " + adjective +
                 " alliance was formed between the " + age + " year olds.",

                 "There was a " + adjective + " villain in town, and he was " +
                 "on the loose. One night, the side kick got an early hold " +
                 "of his location, and quickly rushed in. However, the " +
                 "villain's crew was already waiting, and " +
                 friendName + " was ambushed. Just when " + friendName +
                 " was at a final breath, " + name + " flew right in " +
                 "and threw a smoke bomb. When the gas cleared, both heroes " +
                 "were no where to be seen. The " + age + " year old heroes " +
                 "had to fight another day."

        };

         //generate random index, pick story based on this
         int randIndex = generateRandomStoryIndex();

         return INTROS[randIndex] + " " + RISING_ACTIONS[randIndex];

    }

    //generate a number between 0 and 3 to pick story
    private int generateRandomStoryIndex(){

        return rand.nextInt(4);

    }


}
