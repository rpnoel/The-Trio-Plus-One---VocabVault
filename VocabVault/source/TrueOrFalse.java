// Created by Connor Ilgenfritz

public class TrueFalse extends Question {
    private String question;
    private boolean correctAnswer;

    public TrueFalse(String question, boolean correctAnswer) {
        this.question = question;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return this.question;
    }

    public boolean checkAnswer(boolean userAnswer) {
        return userAnswer == this.correctAnswer;
    }
}
