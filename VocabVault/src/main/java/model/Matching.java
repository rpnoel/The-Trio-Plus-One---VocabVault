package model;

import java.util.ArrayList;

/**
 * Represents a matching question, where the user must match a word to its correct translation.
 * 
 * Created by Connor Ilgenfritz.
 */
public class Matching extends Question {
    
    /**
     * The text of the matching question.
     */
    private String questionText;

    /**
     * The correct answer for the matching question.
     */
    private String correctAnswer;

    /**
     * Constructs a Matching question with the specified word and correct answer.
     *
     * @param word the Word object containing the word to be matched
     * @param correctAnswer the correct answer (translation) for the matching question
     */
    public Matching(Word word, String correctAnswer) {
        this.questionText = "Match the following word with the correct translation: " + word.getWordText();
        this.correctAnswer = correctAnswer;
    }

    /**
     * Checks if the user's answer matches the correct answer, ignoring case.
     *
     * @param userAnswer the answer provided by the user
     * @return true if the user's answer matches the correct answer, false otherwise
     */
    public boolean checkAnswer(String userAnswer) {
        return userAnswer.equalsIgnoreCase(this.correctAnswer);
    }

    /**
     * Gets the correct answer for the matching question.
     *
     * @return the correct answer
     */
    public String getCorrectAnswer() {
        return this.correctAnswer;
    }

    /**
     * Gets the question text for the matching question.
     *
     * @return the question text
     */
    public String getQuestionText() {
        return this.questionText;
    }

    /**
     * Returns a string representation of the matching question.
     *
     * @return the question text as a string
     */
    @Override
    public String toString() {
        return "Question: " + questionText;
    }
}

