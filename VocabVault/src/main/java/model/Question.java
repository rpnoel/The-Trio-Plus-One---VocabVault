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
        if (allChoices.size() < 4) {
            return allChoices; 
        }

        for (int i = 0; i < 4; i++) {
            int index = rand.nextInt(allChoices.size());
            choices.add(allChoices.get(index));
            allChoices.remove(index); // Ensure no duplicate choices
        }

        return choices;
    }

    private ArrayList<String> generateChoices() {
        ArrayList<String> choices = new ArrayList<String>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("txt/answerChoices.txt"));
            String line = reader.readLine();
            while (line != null && choices.size() < 50) {
                choices.add(line);
                line = reader.readLine();
            }
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        return choices;
    }

}
