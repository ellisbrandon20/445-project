package com.example.brandon_e.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Admin on 31-Mar-17.
 */

public class QuizMainActivity extends AppCompatActivity {

    Button buttonTF;
    Button buttonMultiple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_main);

        buttonTF = (Button)findViewById(R.id.buttonTF);
        buttonMultiple =(Button)findViewById(R.id.buttonMultiple);

        buttonTF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(QuizMainActivity.this, MultipleChoiceActivity.class));
            }
        });
        buttonMultiple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(QuizMainActivity.this, QuizActivity.class));
            }
        });
    }
}
