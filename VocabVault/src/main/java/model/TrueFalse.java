package model;

/**
 * Represents a true-or-false question where the user must determine the truthfulness of a statement.
 * 
 * Created by Connor Ilgenfritz.
 */
public class TrueFalse extends Question {

    /**
     * The text of the true-or-false question.
     */
    private String questionText;

    /**
     * The correct answer for the question (true or false).
     */
    private boolean correctAnswer;

    /**
     * Constructs a TrueFalse question with the specified correct answer.
     *
     * @param correctAnswer the correct answer for the question
     */
    public TrueFalse(boolean correctAnswer) {
        this.questionText = "True or False:";
        this.correctAnswer = correctAnswer;
    }

    /**
     * Gets the text of the true-or-false question.
     *
     * @return the question text
     */
    public String getQuestionText() {
        return this.questionText;
    }

    /**
     * Checks if the user's answer matches the correct answer.
     *
     * @param userAnswer the answer provided by the user
     * @return true if the user's answer matches the correct answer, false otherwise
     */
    public boolean checkAnswer(String userAnswer) {
        return userAnswer.equals(this.correctAnswer);
    }

    /**
     * Displays whether the user's answer was correct or incorrect.
     *
     * @param userAnswer the answer provided by the user
     */
    public void correctAnswer(String userAnswer) {
        if (checkAnswer(userAnswer)) {
            System.out.println("The answer was True");
        } else {
            System.out.println("The answer was False");
        }
    }

    /**
     * Returns a string representation of the true-or-false question.
     *
     * @return the question text as a string
     */
    @Override
    public String toString() {
        return "Question: " + questionText;
    }
}
