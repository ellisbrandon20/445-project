package com.example.brandon_e.myapplication;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "DemoInitialApp";
    public static String media = "none";


    public static String getMedia() {
        return media;
    }

    public static void setMedia(String media) {
        MainActivity.media = media;
    }

    public void mediumErrorMsg(){
        Toast.makeText(getApplicationContext(), "You need to select a medium first", Toast.LENGTH_SHORT)
                .show();
    }

    //======================================================================
    // alert dialog for video and text
    public void createTextAlert(String animal) {
        AlertDialog.Builder a_builder = new AlertDialog.Builder(MainActivity.this);
        a_builder.setMessage(animal + "!")
                .setCancelable(true)
                .setPositiveButton("Ok",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = a_builder.create();
        alert.setTitle("Animal Text:");
        alert.show();
    }
    //======================================================================

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // setting the media type

        Button textBtn = (Button) findViewById(R.id.textButton);
        textBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Text is the medium");

                // Toast gives a little pop up message would not be sufficiant for the applicaiton but could be used until we figure out a better pop up
                Toast.makeText(getApplicationContext(), "Click on an Animal to learn the Name", Toast.LENGTH_SHORT)
                        .show();

                // set media type to "text"
                setMedia("text");
            }
        });

        // button to set media type as sound
        Button videoBtn = (Button) findViewById(R.id.videoButton);
        videoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Video is the medium");

                // Toast gives a little pop up message would not be sufficiant for the applicaiton but could be used until we figure out a better pop up
                Toast.makeText(getApplicationContext(), "Click on an Animal Watch a Video", Toast.LENGTH_SHORT)
                        .show();
                // set media type to "text"
                setMedia("video");
            }
        });

        // button to set media type as video
        Button soundBtn = (Button) findViewById(R.id.soundButton);
        soundBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Sound is the medium");

                // Toast gives a little pop up message would not be sufficiant for the applicaiton but could be used until we figure out a better pop up
                Toast.makeText(getApplicationContext(), "Click on an Animal to hear it", Toast.LENGTH_SHORT)
                        .show();

                // set media type to "text"
                setMedia("sound");
            }
        });






        // dog button
        ImageButton dogBtn = (ImageButton) findViewById(R.id.dog_button);
        dogBtn.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View v) {

                if(getMedia().equals("text")){
                    createTextAlert("Dog");
                }
                else{
                    mediumErrorMsg();
                }
            }
        });

        // bear button
        ImageButton bearBtn = (ImageButton) findViewById(R.id.bear_button);
        bearBtn.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View v) {

                if(getMedia().equals("text")){
                    createTextAlert("Bear");
                }
                else{
                    mediumErrorMsg();
                }
            }
        });

        // horse button
        ImageButton horseBtn = (ImageButton) findViewById(R.id.horse_button);
        horseBtn.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View v) {

                if(getMedia().equals("text")){
                    createTextAlert("Horse");
                }
                else{
                    mediumErrorMsg();
                }
            }
        });


    }



}
