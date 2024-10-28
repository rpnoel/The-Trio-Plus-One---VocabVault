package model;
//Created by Connor Ilgenfritz

import java.util.ArrayList;

public class Matching extends Question {
    private String questionText;
    private String correctAnswer;

    public Matching(Word word, String correctAnswer) {
        this.questionText = "Match the following word with the correct translation: "+word.getWordText();
        this.correctAnswer = correctAnswer;
    }

    public boolean checkAnswer(String userAnswer) {
        return userAnswer.equalsIgnoreCase(this.correctAnswer);
    }

    public String getCorrectAnswer() {
        return this.correctAnswer;
    }

    public String getQuestionText() {
        return this.questionText;
    }
}
