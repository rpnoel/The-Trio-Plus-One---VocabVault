package model;
// Created by Connor Ilgenfritz

public class TrueFalse extends Question {
    private String questionText;
    private boolean correctAnswer;

    public TrueFalse(boolean correctAnswer) {
        this.questionText = "True or False:";
        this.correctAnswer = correctAnswer;
    }

    public String getQuestionText() {
        return this.questionText;
    }

    public boolean checkAnswer(boolean userAnswer) {
        return userAnswer == this.correctAnswer;
    }

    public String toString() {
        return "Question: " + questionText + " | Correct Answer: " + correctAnswer;
    }
}
