package com.example.brandon_e.myapplication;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "DemoInitialApp";
    public static String media = "none";

    private MediaPlayer mp = new MediaPlayer();
    private VideoView myVideoView;


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
        a_builder.setMessage("This is a " + animal + "!")
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

        // button to navigate to quiz interface
        Button quizBtn = (Button) findViewById(R.id.quizButton);
        quizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, QuizMainActivity.class);
                startActivity(intent);
            }
        });


        //====================== Animal Buttons ======================== //

        // dog button
        ImageButton dogBtn = (ImageButton) findViewById(R.id.dog_button);
        dogBtn.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View v) {

                if(getMedia().equals("text")){
                    createTextAlert("Dog");
                }
                else if(getMedia().equals("video")) {
                    //============Stuff that does the popup dialog for the window============//
                    final Dialog dialog = new Dialog(MainActivity.this);
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.setContentView(R.layout.video_view);
                    dialog.show();
                    WindowManager.LayoutParams lp = new WindowManager.LayoutParams(
                            ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);
                    lp.copyFrom(dialog.getWindow().getAttributes());
                    dialog.getWindow().setAttributes(lp);
                    VideoView videoview = (VideoView) dialog.findViewById(R.id.videoView2);
                    //=======================================================================//

                    // Change the URI argument depending on what animal is selected
                    // String path1 = "https://www.w3schools.com/html/mov_bbb.mp4";
                    Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.dog);
                    // Uri uri2 = Uri.parse(path1);
                    videoview.setVideoURI(uri);
                    videoview.start();

                }
                else if(getMedia().equals("sound")) {
                    mp = MediaPlayer.create(MainActivity.this, R.raw.cow_sound);
                    mp.start();
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
                else if(getMedia().equals("video")) {
                    //============Stuff that does the popup dialog for the window============//
                    final Dialog dialog = new Dialog(MainActivity.this);
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.setContentView(R.layout.video_view);
                    dialog.show();
                    WindowManager.LayoutParams lp = new WindowManager.LayoutParams(
                            ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);
                    lp.copyFrom(dialog.getWindow().getAttributes());
                    dialog.getWindow().setAttributes(lp);
                    VideoView videoview = (VideoView) dialog.findViewById(R.id.videoView2);
                    //=======================================================================//
                    Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.bear);
                    // Uri uri2 = Uri.parse(path1);
                    videoview.setVideoURI(uri);
                    videoview.start();


                }
                else if(getMedia().equals("sound")) {
                    mp = MediaPlayer.create(MainActivity.this, R.raw.cow_sound);
                    mp.start();
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
                else if(getMedia().equals("video")) {
                    //============Stuff that does the popup dialog for the window============//
                    final Dialog dialog = new Dialog(MainActivity.this);
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.setContentView(R.layout.video_view);
                    dialog.show();
                    WindowManager.LayoutParams lp = new WindowManager.LayoutParams(
                            ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);
                    lp.copyFrom(dialog.getWindow().getAttributes());
                    dialog.getWindow().setAttributes(lp);
                    VideoView videoview = (VideoView) dialog.findViewById(R.id.videoView2);
                    //=======================================================================//
                    Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.horse);
                    // Uri uri2 = Uri.parse(path1);
                    videoview.setVideoURI(uri);
                    videoview.start();


                }
                else if(getMedia().equals("sound")) {

                }
                else{
                    mediumErrorMsg();
                }
            }
        });

        // bird button
        ImageButton birdBtn = (ImageButton) findViewById(R.id.bird_button);
        birdBtn.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View v) {

                if(getMedia().equals("text")){
                    createTextAlert("Bird");
                }
                else if(getMedia().equals("video")) {
                    //============Stuff that does the popup dialog for the window============//
                    final Dialog dialog = new Dialog(MainActivity.this);
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.setContentView(R.layout.video_view);
                    dialog.show();
                    WindowManager.LayoutParams lp = new WindowManager.LayoutParams(
                            ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);
                    lp.copyFrom(dialog.getWindow().getAttributes());
                    dialog.getWindow().setAttributes(lp);
                    VideoView videoview = (VideoView) dialog.findViewById(R.id.videoView2);
                    //=======================================================================//
                    Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.bird);
                    videoview.setVideoURI(uri);
                    videoview.start();

                }
                else if(getMedia().equals("sound")) {

                }
                else{
                    mediumErrorMsg();
                }
            }
        });

        // cat button
        ImageButton catBtn = (ImageButton) findViewById(R.id.cat_button);
        catBtn.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View v) {

                if(getMedia().equals("text")){
                    createTextAlert("Cat");
                }
                else if(getMedia().equals("video")) {
                    //============Stuff that does the popup dialog for the window============//
                    final Dialog dialog = new Dialog(MainActivity.this);
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.setContentView(R.layout.video_view);
                    dialog.show();
                    WindowManager.LayoutParams lp = new WindowManager.LayoutParams(
                            ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);
                    lp.copyFrom(dialog.getWindow().getAttributes());
                    dialog.getWindow().setAttributes(lp);
                    VideoView videoview = (VideoView) dialog.findViewById(R.id.videoView2);
                    //=======================================================================//
                    Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.cat);
                    // Uri uri2 = Uri.parse(path1);
                    videoview.setVideoURI(uri);
                    videoview.start();

                }
                else if(getMedia().equals("sound")) {

                }
                else{
                    mediumErrorMsg();
                }
            }
        });

        // chicken button
        ImageButton chickenBtn = (ImageButton) findViewById(R.id.chicken_button);
        chickenBtn.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View v) {

                if(getMedia().equals("text")){
                    createTextAlert("Chicken");
                }
                else if(getMedia().equals("video")) {
                    //============Stuff that does the popup dialog for the window============//
                    final Dialog dialog = new Dialog(MainActivity.this);
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.setContentView(R.layout.video_view);
                    dialog.show();
                    WindowManager.LayoutParams lp = new WindowManager.LayoutParams(
                            ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);
                    lp.copyFrom(dialog.getWindow().getAttributes());
                    dialog.getWindow().setAttributes(lp);
                    VideoView videoview = (VideoView) dialog.findViewById(R.id.videoView2);
                    //=======================================================================//
                    Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.chicken);
                    // Uri uri2 = Uri.parse(path1);
                    videoview.setVideoURI(uri);
                    videoview.start();


                }
                else if(getMedia().equals("sound")) {


                }
                else{
                    mediumErrorMsg();
                }
            }
        });

        // frog button
        ImageButton frogBtn = (ImageButton) findViewById(R.id.frog_button);
        frogBtn.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View v) {

                if(getMedia().equals("text")){
                    createTextAlert("Frog");
                }
                else if(getMedia().equals("video")) {
                    //============Stuff that does the popup dialog for the window============//
                    final Dialog dialog = new Dialog(MainActivity.this);
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.setContentView(R.layout.video_view);
                    dialog.show();
                    WindowManager.LayoutParams lp = new WindowManager.LayoutParams(
                            ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);
                    lp.copyFrom(dialog.getWindow().getAttributes());
                    dialog.getWindow().setAttributes(lp);
                    VideoView videoview = (VideoView) dialog.findViewById(R.id.videoView2);
                    //=======================================================================//
                    Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.frog);
                    // Uri uri2 = Uri.parse(path1);
                    videoview.setVideoURI(uri);
                    videoview.start();


                }
                else if(getMedia().equals("sound")) {

                }
                else{
                    mediumErrorMsg();
                }
            }
        });

        // cow button
        ImageButton cowBtn = (ImageButton) findViewById(R.id.cow_button);
        cowBtn.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View v) {

                if(getMedia().equals("text")){
                    createTextAlert("Cow");
                }
                else if (getMedia().equals("video")) {
                    //============Stuff that does the popup dialog for the window============//
                    final Dialog dialog = new Dialog(MainActivity.this);
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.setContentView(R.layout.video_view);
                    dialog.show();
                    WindowManager.LayoutParams lp = new WindowManager.LayoutParams(
                            ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);
                    lp.copyFrom(dialog.getWindow().getAttributes());
                    dialog.getWindow().setAttributes(lp);
                    VideoView videoview = (VideoView) dialog.findViewById(R.id.videoView2);
                    //=======================================================================//
                    Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.cow);
                    // Uri uri2 = Uri.parse(path1);
                    videoview.setVideoURI(uri);
                    videoview.start();


                }
                else if(getMedia().equals("sound")) {
                    mp = MediaPlayer.create(MainActivity.this, R.raw.cow_sound);
                    mp.start();
                }
                else{
                    mediumErrorMsg();
                }
            }
        });

        // elephant button
        ImageButton elephantBtn = (ImageButton) findViewById(R.id.elephant_button);
        elephantBtn.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View v) {

                if(getMedia().equals("text")){
                    createTextAlert("Elephant");
                }
                else if(getMedia().equals("video")) {
                    //============Stuff that does the popup dialog for the window============//
                    final Dialog dialog = new Dialog(MainActivity.this);
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.setContentView(R.layout.video_view);
                    dialog.show();
                    WindowManager.LayoutParams lp = new WindowManager.LayoutParams(
                            ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);
                    lp.copyFrom(dialog.getWindow().getAttributes());
                    dialog.getWindow().setAttributes(lp);
                    VideoView videoview = (VideoView) dialog.findViewById(R.id.videoView2);
                    //=======================================================================//
                    Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.elephant);
                    // Uri uri2 = Uri.parse(path1);
                    videoview.setVideoURI(uri);
                    videoview.start();


                }
                else if(getMedia().equals("sound")) {

                }
                else{
                    mediumErrorMsg();
                }
            }
        });

        // lion button
        ImageButton lionBtn = (ImageButton) findViewById(R.id.lion_button);
        lionBtn.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View v) {

                if(getMedia().equals("text")){
                    createTextAlert("Lion");
                }
                else if(getMedia().equals("video")) {
                    //============Stuff that does the popup dialog for the window============//
                    final Dialog dialog = new Dialog(MainActivity.this);
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.setContentView(R.layout.video_view);
                    dialog.show();
                    WindowManager.LayoutParams lp = new WindowManager.LayoutParams(
                            ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);
                    lp.copyFrom(dialog.getWindow().getAttributes());
                    dialog.getWindow().setAttributes(lp);
                    VideoView videoview = (VideoView) dialog.findViewById(R.id.videoView2);
                    //=======================================================================//
                    Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.lion);
                    // Uri uri2 = Uri.parse(path1);
                    videoview.setVideoURI(uri);
                    videoview.start();


                }
                else if(getMedia().equals("sound")) {

                }
                else{
                    mediumErrorMsg();
                }
            }
        });

        // pig button
        ImageButton pigBtn = (ImageButton) findViewById(R.id.pig_button);
        pigBtn.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View v) {

                if(getMedia().equals("text")){
                    createTextAlert("Pig");
                }
                else if(getMedia().equals("video")) {
                    //============Stuff that does the popup dialog for the window============//
                    final Dialog dialog = new Dialog(MainActivity.this);
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.setContentView(R.layout.video_view);
                    dialog.show();
                    WindowManager.LayoutParams lp = new WindowManager.LayoutParams(
                            ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);
                    lp.copyFrom(dialog.getWindow().getAttributes());
                    dialog.getWindow().setAttributes(lp);
                    VideoView videoview = (VideoView) dialog.findViewById(R.id.videoView2);
                    //=======================================================================//
                    Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.pig);
                    // Uri uri2 = Uri.parse(path1);
                    videoview.setVideoURI(uri);
                    videoview.start();


                }
                else if(getMedia().equals("sound")) {

                }
                else{
                    mediumErrorMsg();
                }
            }
        });

        // monkey button
        ImageButton monkeyBtn = (ImageButton) findViewById(R.id.monkey_button);
        monkeyBtn.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View v) {

                if(getMedia().equals("text")){
                    createTextAlert("Monkey");
                }
                else if(getMedia().equals("video")) {
                    //============Stuff that does the popup dialog for the window============//
                    final Dialog dialog = new Dialog(MainActivity.this);
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.setContentView(R.layout.video_view);
                    dialog.show();
                    WindowManager.LayoutParams lp = new WindowManager.LayoutParams(
                            ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);
                    lp.copyFrom(dialog.getWindow().getAttributes());
                    dialog.getWindow().setAttributes(lp);
                    VideoView videoview = (VideoView) dialog.findViewById(R.id.videoView2);
                    //=======================================================================//
                    Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.monkey);
                    // Uri uri2 = Uri.parse(path1);
                    videoview.setVideoURI(uri);
                    videoview.start();


                }
                else if(getMedia().equals("sound")) {

                }
                else{
                    mediumErrorMsg();
                }
            }
        });

        // snake button
        ImageButton snakeBtn = (ImageButton) findViewById(R.id.snake_button);
        snakeBtn.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View v) {

                if(getMedia().equals("text")){
                    createTextAlert("Snake");
                }
                else if(getMedia().equals("video")) {
                    //============Stuff that does the popup dialog for the window============//
                    final Dialog dialog = new Dialog(MainActivity.this);
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.setContentView(R.layout.video_view);
                    dialog.show();
                    WindowManager.LayoutParams lp = new WindowManager.LayoutParams(
                            ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);
                    lp.copyFrom(dialog.getWindow().getAttributes());
                    dialog.getWindow().setAttributes(lp);
                    VideoView videoview = (VideoView) dialog.findViewById(R.id.videoView2);
                    //=======================================================================//
                    Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.snake);
                    // Uri uri2 = Uri.parse(path1);
                    videoview.setVideoURI(uri);
                    videoview.start();


                }
                else if(getMedia().equals("sound")) {

                }
                else{
                    mediumErrorMsg();
                }
            }
        });

        // duck button
        ImageButton duckBtn = (ImageButton) findViewById(R.id.duck_button);
        duckBtn.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View v) {

                if(getMedia().equals("text")){
                    createTextAlert("Duck");
                }
                else if(getMedia().equals("video")) {
                    //============Stuff that does the popup dialog for the window============//
                    final Dialog dialog = new Dialog(MainActivity.this);
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.setContentView(R.layout.video_view);
                    dialog.show();
                    WindowManager.LayoutParams lp = new WindowManager.LayoutParams(
                            ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);
                    lp.copyFrom(dialog.getWindow().getAttributes());
                    dialog.getWindow().setAttributes(lp);
                    VideoView videoview = (VideoView) dialog.findViewById(R.id.videoView2);
                    //=======================================================================//
                    Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.duck);
                    // Uri uri2 = Uri.parse(path1);
                    videoview.setVideoURI(uri);
                    videoview.start();
                }
                else if(getMedia().equals("sound")) {

                }
                else{
                    mediumErrorMsg();
                }
            }
        });

        // penguin button
        ImageButton penguinBtn = (ImageButton) findViewById(R.id.penguin_button);
        penguinBtn.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View v) {

                if(getMedia().equals("text")){
                    createTextAlert("Penguin");
                }
                else if(getMedia().equals("video")) {
                    //============Stuff that does the popup dialog for the window============//
                    final Dialog dialog = new Dialog(MainActivity.this);
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.setContentView(R.layout.video_view);
                    dialog.show();
                    WindowManager.LayoutParams lp = new WindowManager.LayoutParams(
                            ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);
                    lp.copyFrom(dialog.getWindow().getAttributes());
                    dialog.getWindow().setAttributes(lp);
                    VideoView videoview = (VideoView) dialog.findViewById(R.id.videoView2);
                    //=======================================================================//
                    Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.penguin);
                    // Uri uri2 = Uri.parse(path1);
                    videoview.setVideoURI(uri);
                    videoview.start();


                }
                else if(getMedia().equals("sound")) {

                }
                else{
                    mediumErrorMsg();
                }
            }
        });

        // fishBtn button
        ImageButton fishBtn = (ImageButton) findViewById(R.id.fish_button);
        fishBtn.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View v) {

                if(getMedia().equals("text")){
                    createTextAlert("Fish");
                }
                else if(getMedia().equals("video")) {
                    //============Stuff that does the popup dialog for the window============//
                    final Dialog dialog = new Dialog(MainActivity.this);
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.setContentView(R.layout.video_view);
                    dialog.show();
                    WindowManager.LayoutParams lp = new WindowManager.LayoutParams(
                            ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);
                    lp.copyFrom(dialog.getWindow().getAttributes());
                    dialog.getWindow().setAttributes(lp);
                    VideoView videoview = (VideoView) dialog.findViewById(R.id.videoView2);
                    //=======================================================================//
                    Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.fish);
                    // Uri uri2 = Uri.parse(path1);
                    videoview.setVideoURI(uri);
                    videoview.start();

                }
                else if(getMedia().equals("sound")) {

                }
                else{
                    mediumErrorMsg();
                }
            }
        });
    }



}
