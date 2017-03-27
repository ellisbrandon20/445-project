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
                Toast.makeText(getApplicationContext(), "Click on Animal to learn the Name", Toast.LENGTH_SHORT)
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
//                    Toast.makeText(getApplicationContext(), "Image_1", Toast.LENGTH_SHORT)
//                            .show();

                    AlertDialog.Builder a_builder = new AlertDialog.Builder(MainActivity.this);
                    a_builder.setMessage("Image_1")
                        .setCancelable(true)
//                            .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
//                                @Override
//                                public void onClick(DialogInterface dialog, int which) {
//                                    finish();
//                                }
//                            })
//                            .setNegativeButton("No",new DialogInterface.OnClickListener() {
//                                @Override
//                                public void onClick(DialogInterface dialog, int which) {
//                                    dialog.cancel();
//                                }
//                            }) ;
                        .setPositiveButton("Ok",new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                }) ;
                    AlertDialog alert = a_builder.create();
                    alert.setTitle("Animal Text:");
                    alert.show();

                }
                else{
                    Toast.makeText(getApplicationContext(), "Poopy", Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });
    }



}
