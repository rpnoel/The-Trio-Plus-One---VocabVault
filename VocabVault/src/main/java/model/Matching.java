package model;
//Created by Connor Ilgenfritz

import java.util.ArrayList;

public class Matching extends Question {
    private String questionText;
    private ArrayList<String> choices;
    private String correctAnswer;

    public Matching(Word word, ArrayList<String> choices, String correctAnswer) {
        this.questionText = "Match the following word with the correct translation: "+word.getWordText();
        this.choices = choices;
        this.correctAnswer = correctAnswer;
    }

    public boolean checkAnswer(String userAnswer) {
        return userAnswer.equalsIgnoreCase(this.correctAnswer);
    }

    public String getCorrectAnswer() {
        return this.correctAnswer;
    }

    public ArrayList<String> getChoices() {
        return this.choices;
    }

    public String getQuestionText() {
        return this.questionText;
    }
}
