package model;
//@author Max Granger

public class FillInTheBlank extends Question {
    public String questionText;
    public String correctAnswer;
    
    public FillInTheBlank(Word word) {
        this.questionText = "Translate the following to Spanish: " + word.getTranslation();
        this.correctAnswer = word.getWordText();
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