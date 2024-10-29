package model;
//@author Max Granger

public class FillInTheBlank extends Question {
    public String questionText;
    public String correctAnswer;
    public String userAnswer;
    
    public FillInTheBlank(Word word) {
        this.questionText = "Translate the following to Spanish: " + word.getTranslation();
        this.correctAnswer = word.getWordText();
    }

    public FillInTheBlank(Question q) {
        this.questionText = q.getQText();
        this.correctAnswer = q.getWord().getTranslation();
    }

    public String getCorrAnswer() {
        return this.correctAnswer;
    }

    @Override
    public String toString() {
        return "Question: " + questionText;
    }
}