package model;
import java.util.ArrayList;

public abstract class Question {
    private String questionText;
    private ArrayList<String> choices;

    public String getQText() {
        return this.questionText;
    }

    public ArrayList<String> getChoices() {
        return this.choices;
    }
}
