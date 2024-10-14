// @author Max Granger
import java.util.ArrayList;

public class MultipleChoice extends Question {
    private String questionText;
    private ArrayList<String> choices;
    private int correctAnswer; //correct answer 1-4

    public MultipleChoice(String questionText, ArrayList<String> choices, int correctAnswer) {
        this.questionText = questionText;
        this.choices = choices;
        this.correctAnswer = correctAnswer;
    }

    public String getQString() {
        return this.questionText;
    }

    public ArrayList<String> getChoices() {
        return this.choices;
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
