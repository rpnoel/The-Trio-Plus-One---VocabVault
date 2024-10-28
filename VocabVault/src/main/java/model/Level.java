package src.main.java.model;
import java.util.ArrayList;

public class Level {
    private ArrayList<Question> questions;
    private boolean complete;
    private int levelNum;
    private int qNum; //number of questions

    public Level(int levelNum, int qNum, Book sourceBook){
        this.levelNum = levelNum;
        this.qNum = qNum;
        ArrayList<Word> vocabWords = sourceBook.getVocabWords();
        for (Word word : vocabWords) {
            questions.add(generateQ(word))
        }
    }

    private Question generateQ(Word word, boolean truefalse, String correctanswer) {
        qNum++;
        if (qNum % 4 == 0) {
            return new TrueFalse(truefalse);
        } else if (qNum % 3 == 0) {
            return new FillInTheBlank(word);
        } else if (qNum % 2 == 0) {
            return new Matching(word, correctanswer); //return matching game type question
        } else {
            return new MultipleChoice(word);
        }
    }

    public ArrayList<Question> getAllQuestions(){
        return this.questions;
    }

    public Question getQuestion(int questionType){
        // 1 - multiple choice, 2 - mathcing, 3 - fill in the blank - 4 - true or false
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

    public boolean getComplete(){
        return true;
    }

    public void setComplete(Boolean booL){
        
    }
}
