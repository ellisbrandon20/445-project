package com.example.brandon_e.myapplication;

/**
 * Created by joseramos on 3/29/17.
 */

public class AnimalQuiz {

    ////////////////////////////////True & False///////////////////////////////////////////////////
    public static int[] images = new int [] {
            R.drawable.bear,
            R.drawable.bird,
            R.drawable.cat,
            R.drawable.chicken,
            R.drawable.fish,
            R.drawable.horse,
            R.drawable.lion,
            R.drawable.penguin,
            R.drawable.pig,
            R.drawable.monkey,
            R.drawable.duck,
            R.drawable.elephant,
            R.drawable.dog,
            R.drawable.snake,
            R.drawable.cow,
            R.drawable.frog,
    };

    public static String[] trueFalseChoices = new String [] {
            "Bear",
            "Bird",
            "Lion",
            "Chicken",
            "Frog",
            "Lion",
            "Cow",
            "Penguin",
            "Pig",
            "Dog", // 10
            "Chicken", // 11
            "Elephant",
            "Dog",
            "Frog",
            "Cow",
            "Frog"

    };

    public static boolean[] trueFalseAnswers = new boolean[]{
            true,
            true,
            false,
            true,
            false,
            false,
            false,
            true,
            true,
            false, // 10
            false,
            true,
            true,
            false,
            true,
            true,
    };




    //////////////////////Multiple choice////////////////////////////////

    private String multipleChoices [][]= {
            {"Snake", "Bear", "Duck", "Fish"},
            {"Bird", "Duck", "Cat", "Pig"},
            {"Cat", "Pig", "Duck", "Fish"},
            {"Dog", "Duck", "Fish", "Chicken"},
            {"Cow", "Snake", "Duck", "Fish"},
            {"Horse", "Cow", "Elephant", "Dog"},
            {"Dog", "Cat", "Lion", "Fish"},
            {"Bird", "Penguin", "Duck", "Fish"},
            {"Pig", "Snake", "Monkey", "Frog"},
            {"Penguin", "Monkey", "Duck", "Dog"},
            {"Duck", "Fish", "Snake", "Chicken"},
            {"Dog", "Elephant", "Penguin", "Cow"},
            {"Fish", "Dog", "Duck", "Monkey"},
            {"Bear", "Cow", "Snake", "Bird"},
            {"Cow", "Bear", "Duck", "Penguin"},
            {"Bird", "Frog", "Pig", "Snake"}

    };


    private String multipleChoiceAnswer [] = {
            "Bear",
            "Bird",
            "Cat",
            "Chicken",
            "Fish",
            "Horse",
            "Lion",
            "Penguin",
            "Pig",
            "Monkey",
            "Duck",
            "Elephant",
            "Dog",
            "Snake",
            "Cow",
            "Frog"
    };


    public int numOfQuestions(){
        return images.length;
    }

    public String getChoice1(int a) {
        return multipleChoices[a][0];
    }

    public String getChoice2(int a) {
        return multipleChoices[a][1];

    }

    public String getChoice3(int a) {
        return multipleChoices[a][2];

    }

    public String getChoice4(int a) {
        return multipleChoices[a][3];
    }


    public String getCorrectAnswer(int a) {
        return multipleChoiceAnswer[a];
    }

}
