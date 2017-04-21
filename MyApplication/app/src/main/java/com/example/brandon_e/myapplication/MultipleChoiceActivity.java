package com.example.brandon_e.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MultipleChoiceActivity extends AppCompatActivity {

    AnimalQuiz quizDb = new AnimalQuiz();

    private TextView ScoreView;
    private ImageView ImageView;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;


    private String Answer;
    private int Score = 0;
    private int questionNumber = 0;
    private int flipBeteenActivities = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_choice);

        ScoreView = (TextView)findViewById(R.id.points);
        ImageView = (ImageView)findViewById(R.id.imageView);
        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        button4 = (Button)findViewById(R.id.button4);

        updateQuestion();

        /////////////////////////////////////////Buttons Logic///////////////////////////////////////////
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonLogic(button1);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    buttonLogic(button2);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonLogic(button3);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonLogic(button4);
            }
        });



    }

    private void buttonLogic(Button button){

        if(button.getText() == Answer) {
            Score++;
            updateScore(Score);

            if (questionNumber == quizDb.numOfQuestions()) {
                intentLogic();
            } else {
                updateQuestion();
            }
        }
        else {
            if (questionNumber == quizDb.numOfQuestions()) {
                intentLogic();
            } else {
                updateQuestion();
            }
        }
    }

    private void intentLogic(){///Passing final score to ResultsActivity
        Intent intentResults = new Intent(MultipleChoiceActivity.this, ResultsActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("finalScore", Score);
        intentResults.putExtras(bundle);
        MultipleChoiceActivity.this.finish();
        startActivity(intentResults);
    }

    private void updateQuestion() {
        ImageView.setImageResource(quizDb.images[questionNumber]);
        button1.setText(quizDb.getChoice1(questionNumber));
        button2.setText(quizDb.getChoice2(questionNumber));
        button3.setText(quizDb.getChoice3(questionNumber));
        button4.setText(quizDb.getChoice4(questionNumber));
        Answer = quizDb.getCorrectAnswer(questionNumber);
        questionNumber++;
    }

    private void updateScore(int point) {
        ScoreView.setText("" + Score);
    }
}
