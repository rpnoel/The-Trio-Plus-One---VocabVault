//@author Max Granger

public class FillInTheBlank extends Question {
    public String questionText;
    public String correctAnswer;
    
    public FillInTheBlank(String questionText, String correctAnswer) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
    }

    public String getQString() {
        return this.questionText;
    }

    public String getCorrAnswer() {
        return this.correctAnswer;
    }

    public boolean checkAnswer(String userAnswer) {
        if (userAnswer != null) {
            if (userAnswer.equals(this.correctAnswer)) {
                return true;
            }
        }
        return false;
    }
}