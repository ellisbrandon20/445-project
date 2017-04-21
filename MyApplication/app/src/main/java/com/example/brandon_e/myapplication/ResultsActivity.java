package com.example.brandon_e.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {

    AnimalQuiz quizDb = new AnimalQuiz();
    TextView  finalScore;
    Button retryButton;
    Button homeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        finalScore = (TextView)findViewById(R.id.outOf);
        retryButton = (Button)findViewById(R.id.retry);
        homeButton = (Button)findViewById(R.id.homeButton);

        Bundle bundle = getIntent().getExtras();
        int score = bundle.getInt("finalScore");

        finalScore.setText("You scored " + score + " out of " + quizDb.numOfQuestions());

        retryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ResultsActivity.this, QuizMainActivity.class));
                ResultsActivity.this.finish();
            }
        });

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ResultsActivity.this, MainActivity.class));
                ResultsActivity.this.finish();
            }
        });

    }
}