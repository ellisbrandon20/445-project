package com.example.brandon_e.myapplication;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button textBtn = (Button) findViewById(R.id.textButton);
        textBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "This is a magic log message!");

                // Toast gives a little pop up message would not be sufficiant for the applicaiton but could be used until we figure out a better pop up
                Toast.makeText(getApplicationContext(), "This is Toast Magic", Toast.LENGTH_SHORT)
                        .show();

                // set media type to "text"
                setMedia("text");
            }
        });


        ImageButton imageBtn_1 = (ImageButton) findViewById(R.id.imageButton_1);
        imageBtn_1.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View v) {

                if(getMedia().equals("text")){
                    // Toast gives a little pop up message would not be sufficiant for the applicaiton but could be used until we figure out a better pop up
                    Toast.makeText(getApplicationContext(), "Image_1", Toast.LENGTH_SHORT)
                            .show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Poopy", Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });
    }



}
