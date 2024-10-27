//Created by Connor Ilgenfritz

import java.util.ArrayList;

public class Matching extends Question {
    private String questionText;
    private ArrayList<String> choices;
    private String correctAnswer;
    private QuestionType questionType;

    public Matching(String questionText, ArrayList<String> choices, String correctAnswer, QuestionType questionType) {
        this.questionText = questionText;
        this.choices = choices;
        this.correctAnswer = correctAnswer;
        this.questionType = questionType;
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

    public QuestionType getQuestionType() {
        return this.questionType;
    }
}
