import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UserProgressTracker {
    private User user;
    private int totalQuestionsAnswered;
    private int correctAnswers;
    private Map<Question, Integer> missedQuestions;

    public UserProgressTracker(User user) {
        this.user = user;
        this.totalQuestionsAnswered = 0;
        this.correctAnswers = 0;
        this.missedQuestions = new HashMap<>();
    }

    /**
     * Logs an answered question and updates performance stats.
     *
     * @param question The question answered.
     * @param isCorrect Whether the user answered correctly.
     */
    public void logAnswer(Question question, boolean isCorrect) {
        totalQuestionsAnswered++;
        if (isCorrect) {
            correctAnswers++;
        } else {
            missedQuestions.put(question, missedQuestions.getOrDefault(question, 0) + 1);
        }
    }

    /**
     * Gets the user's overall accuracy as a percentage.
     *
     * @return The accuracy percentage.
     */
    public double getAccuracy() {
        if (totalQuestionsAnswered == 0) return 0;
        return (double) correctAnswers / totalQuestionsAnswered * 100;
    }

    /**
     * Returns a list of questions the user commonly misses.
     *
     * @return ArrayList of commonly missed questions.
     */
    public ArrayList<Question> getCommonlyMissedQuestions() {
        ArrayList<Question> commonlyMissed = new ArrayList<>();
        for (Map.Entry<Question, Integer> entry : missedQuestions.entrySet()) {
            if (entry.getValue() > 1) {
                commonlyMissed.add(entry.getKey());
            }
        }
        return commonlyMissed;
    }

    /**
     * Displays a summary of the user's progress.
     */
    public void displayProgress() {
        System.out.println("User: " + user.getUsername());
        System.out.println("Total Questions Answered: " + totalQuestionsAnswered);
        System.out.println("Correct Answers: " + correctAnswers);
        System.out.println("Accuracy: " + getAccuracy() + "%");
        System.out.println("Commonly Missed Questions:");
        for (Question question : getCommonlyMissedQuestions()) {
            System.out.println("- " + question.getQuestionText());
        }
    }
}
