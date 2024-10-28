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

    public boolean checkAnswer(String userAnswer) {
        return userAnswer.equals(this.correctAnswer);
    }

    public void correctAnswer(String userAnswer) {
        if(checkAnswer(userAnswer)){
            System.out.println("The answer was True");
        } else {
            System.out.println("The answer was False");
        }
    }

    public String toString() {
        return "Question: " + questionText;
    }
}
