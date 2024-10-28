package model;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Random;

public abstract class Question {
    private String questionText;
    private ArrayList<String> choices;

    public String getQText() {
        return this.questionText;
    }

    public ArrayList<String> getChoices() {
        ArrayList<String> allChoices = generateChoices();
        Random rand = new Random();
        this.choices = new ArrayList<String>();
        for (int i = 0; i < 4; i++) {
            choices.add(allChoices.get(rand.nextInt(50)));
        }
        return choices;
    }

    private ArrayList<String> generateChoices() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("VocabVault\\txt\\answerChoices.txt"));
            ArrayList<String> choices = new ArrayList<String>();
            String line = reader.readLine();
            while (line != null) {
                choices.add(line);
            }
            return choices;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
