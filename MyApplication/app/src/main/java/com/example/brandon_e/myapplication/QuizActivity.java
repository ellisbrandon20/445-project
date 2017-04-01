package com.example.brandon_e.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class QuizActivity extends AppCompatActivity {

    private TextView ScoreView;
    private TextView Question;
    private ImageView ImageView;
    private Button button1;
    private Button button2;

    AnimalQuiz quizDb = new AnimalQuiz();

    private boolean Answer;
    private int Score = 0;
    private int questionNumber = 0;
    private int counter = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        ScoreView = (TextView)findViewById(R.id.points);
        ImageView = (ImageView)findViewById(R.id.imageView);
        Question = (TextView)findViewById(R.id.question);
        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);

        updateQuestion();

        ///////////Buttons Logic////
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean bool = true;
                buttonLogic(button1,bool);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean bool = false;
                buttonLogic(button1,bool);
            }
        });
    }

    private void buttonLogic(Button button, boolean bool){

        if(Answer = bool) {
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
        Intent intentResults = new Intent(QuizActivity.this, ResultsActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("finalScore", Score);
        intentResults.putExtras(bundle);
        QuizActivity.this.finish();
        startActivity(intentResults);
    }


    private void updateQuestion() {
        ImageView.setImageResource(quizDb.images[questionNumber]);
        Question.setText(quizDb.trueFalseChoices[questionNumber]);
        Answer = quizDb.trueFalseAnswers[questionNumber];
        questionNumber++;
        counter++;
    }

    private void updateScore(int point) {
        ScoreView.setText("" + Score);
    }

}
