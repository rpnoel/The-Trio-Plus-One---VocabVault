package model;
// @author Max Granger
import java.util.ArrayList;


public class MultipleChoice extends Question {
    private String questionText;
    private ArrayList<String> choices;
    private int correctAnswer; //correct answer 1-4

    public MultipleChoice(Word word) {
        this.questionText = "Choose the correct translation of " + word.getWordText() + ".";
        this.correctAnswer = (int) Math.random() * 4;
        this.choices = getChoices();
        choices.add(correctAnswer, word.getTranslation());
    }

    public int getCorrAnswer() {
        return this.correctAnswer;
    }

    public String getCorrectAnswerText() {
        return choices.get(correctAnswer); 
    }

    public boolean checkAnswer(int userAnswer) {
        if (userAnswer < 5 || userAnswer > 0) {
            if (userAnswer == this.correctAnswer) {
                return true;
            }
        }
        return false;
    }

    public String toString(){
        return questionText + "\n\t1. " + choices.get(0) + "\n\t2. " + choices.get(1) + "\n\t3. " + choices.get(2) + "\n\t4. " + choices.get(3) + "\n";
    }

    
}
