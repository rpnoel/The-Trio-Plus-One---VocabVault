package model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Represents a level in a language learning application. Each level contains a set
 * of questions based on vocabulary words from a source book.
 */
public class Level {
    /**
     * The list of questions in this level.
     */
    private ArrayList<Question> questions;

    /**
     * The level number for this level.
     */
    private int levelNum;

    /**
     * The number of questions generated for this level.
     */
    private int qNum = 0;

    /**
     * Constructs a Level with the specified level number and a source book.
     * Populates the level with questions based on vocabulary words in the book.
     * 
     * @param levelNum the level number
     * @param sourceBook the source book from which vocabulary words are taken
     */
    public Level(int levelNum, Book sourceBook) {
        this.levelNum = levelNum;
        this.questions = new ArrayList<>();
        populateQ(sourceBook);
        System.out.println(getAllQuestions().toString());
    }

    /**
     * Populates the questions list using vocabulary words from the source book.
     * Each word generates a specific type of question in the list.
     * 
     * @param sourceBook the book containing vocabulary words
     */
    private void populateQ(Book sourceBook) {
        ArrayList<Word> vocabWords = sourceBook.getVocabWords();
        Iterator<Word> iterator = vocabWords.iterator();
        while (iterator.hasNext()) {
            Word word = iterator.next();
            questions.add(generateQ(word, true, word.getTranslation()));
            iterator.remove();
        }
    }

    /**
     * Generates a question based on the provided word and question parameters.
     * Alternates between question types based on the question count.
     * 
     * @param word the vocabulary word for the question
     * @param truefalse the correct answer for TrueFalse question types
     * @param correctanswer the correct answer text for Matching question types
     * @return the generated question
     */
    private Question generateQ(Word word, boolean truefalse, String correctanswer) {
        qNum++;
        if (qNum % 4 == 0) {
            return new TrueFalse(truefalse);
        } else if (qNum % 3 == 0) {
            return new FillInTheBlank(word);
        } else if (qNum % 2 == 0) {
            return new Matching(word, correctanswer);
        } else {
            return new MultipleChoice(word);
        }
    }

    /**
     * Retrieves the list of all questions in this level.
     * 
     * @return an ArrayList of questions in the level
     */
    public ArrayList<Question> getAllQuestions() {
        return this.questions;
    }

    /**
     * Retrieves a question of the specified type.
     * 
     * @param questionType the type of question to retrieve (1 - Multiple Choice, 2 - Matching, 3 - Fill in the Blank, 4 - True or False)
     * @return the question of the specified type, or the first question if type is unknown
     */
    public Question getQuestion(int questionType) {
        // 1 - multiple choice, 2 - matching, 3 - fill in the blank, 4 - true or false
        if (questionType == 1) {
            return questions.get(0);
        } else if (questionType == 2) {
            return questions.get(1);
        } else if (questionType == 3) {
            return questions.get(2);
        } else {
            return questions.get(3);
        }
    }

    /**
     * Indicates whether the level has been completed.
     * 
     * @return true if the level is complete, false otherwise
     */
    public boolean getComplete() {
        return true;
    }

    /**
     * Sets the completion status of the level.
     * 
     * @param booL the completion status to set
     */
    public void setComplete(Boolean booL) {
        
    }
}

