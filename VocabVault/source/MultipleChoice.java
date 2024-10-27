// @author Max Granger
import java.util.ArrayList;


public class MultipleChoice extends Question {
    private String questionText;
    private ArrayList<String> choices;
    private int correctAnswer; //correct answer 1-4

    public MultipleChoice(Word word, ArrayList<String> otherChoices) {
        this.questionText = "Choose the correct translation of " + word.getWordText() + ".";
        this.choices = otherChoices;
        this.correctAnswer = (int) Math.random() * 4;
        choices.add(correctAnswer, word.getTranslation());
    }

    public int getCorrAnswer() {
        return this.correctAnswer;
    }

    public boolean checkAnswer(int userAnswer) {
        if (userAnswer < 5 || userAnswer > 0) {
            if (userAnswer == this.correctAnswer) {
                return true;
            }
        }
        return false;
    }
}
