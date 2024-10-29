package model;

import java.util.ArrayList;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Random;

/**
 * Represents an abstract question with a question text and a set of answer choices.
 * This class provides methods for retrieving the question text and generating random choices.
 */
public abstract class Question {
    
    /**
     * The text of the question.
     */
    private String questionText;
<<<<<<< HEAD
    private Word word;
=======

    /**
     * The list of answer choices for the question.
     */
>>>>>>> e199ad8f4b5927fd09de0e91b2632ed39c935a4c
    private ArrayList<String> choices;

    /**
     * Gets the text of the question.
     * 
     * @return the question text
     */
    public String getQText() {
        return this.questionText;
    }

<<<<<<< HEAD
    public Word getWord() {
        return this.word;
    }

=======
    /**
     * Gets a list of four random answer choices, ensuring no duplicates.
     * If there are fewer than four choices available, returns all available choices.
     * 
     * @return a list of answer choices
     */
>>>>>>> e199ad8f4b5927fd09de0e91b2632ed39c935a4c
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

    /**
     * Generates a list of potential answer choices by reading from a file.
     * Reads up to 50 lines from the specified file and adds them to the choices list.
     * 
     * @return a list of answer choices, or null if an error occurs
     */
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
<<<<<<< HEAD

    public boolean checkAnswer(int qType, String userAnswer) {
        if (qType == 3) {
            if (userAnswer == this.getWord().getTranslation()) {
            return true;
            }
        } else if (qType == 2) {
            int userInt = Integer.parseInt(userAnswer);
            if (userInt < 5 || userInt > 0) {
                if (this.getChoices().get(userInt).equals(userAnswer)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
=======
>>>>>>> e199ad8f4b5927fd09de0e91b2632ed39c935a4c
}
