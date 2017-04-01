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
            "Cat",
            "Chicken",
            "Fish",
            "Lion",
            "Lion",
            "Pinguin",
            "Pig",
            "Monkey",
            "Duck",
            "Elephant",
            "Dog",
            "Snake",
            "Cow",
            "Frog"

    };

    public static boolean[] trueFalseAnswers = new boolean[]{
            true,
            true,
            true,
            true,
            true,
            true,
            true,
            true,
            true,
            true,
            true,
            true,
            true,
            true,
            true,
            true,
    };




    //////////////////////Multiple choice////////////////////////////////

    private String multipleChoices [][] = {
            {"Bear", "Snake"},
            {"Bird", "Duck"},
            {"Cat", "Fish"},
            {"Chicken", "Dog"},
            {"Fish", "Cow"},
            {"Horse", "Cow"},
            {"Lion", "Fish"},
            {"Pinguin", "Bird"},
            {"Pig", "Snake"},
            {"Monkey", "Duck"},
            {"Duck", "Fish"},
            {"Elephent", "Dog"},
            {"Dog", "Fish"},
            {"Snake", "Cow"},
            {"Cow", "Fish"},
            {"Frog", "Bird"}

    };


    private String multipleChoiceAnswer [] = {
            "Bear",
            "Bird",
            "Cat",
            "Chicken",
            "Fish",
            "Horse",
            "Lion",
            "Pinguin",
            "Pig",
            "Monkey",
            "Duck",
            "Elephent",
            "Dog",
            "Snake",
            "Cow",
            "Frog"
    };


    public int numOfQuestions(){
        return images.length;
    }

    public String getChoice1(int a) {
        String choice0 = multipleChoices[a][0];
        return choice0;
    }

    public String getChoice2(int a) {
        String choice1 = multipleChoices[a][1];
        return choice1;
    }



    public String getCorrectAnswer(int a) {
        String answer = multipleChoiceAnswer[a];
        return answer;
    }

}
