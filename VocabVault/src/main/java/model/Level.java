package model;
import java.util.ArrayList;

public class Level {
    private ArrayList<Question> questions;
    private boolean complete;
    private int levelNum;
    private int qNum; //number of questions

    public Level(int levelNum, Book sourceBook){
        this.levelNum = levelNum;

    }

    private Question generateQ(Word word, ArrayList<String> choices, boolean truefalse, String correctanswer) {
        qNum++;
        if (qNum % 4 == 0) {
            return new TrueFalse(truefalse);
        } else if (qNum % 3 == 0) {
            return new FillInTheBlank(word);
        } else if (qNum % 2 == 0) {
            return new Matching(word, choices, correctanswer); //return matching game type question
        } else {
            return new MultipleChoice(word, choices);
        }
    }

    public ArrayList<Question> getAllQuestions(){
        return this.questions;
    }

    public Question getQuestion(int questionType){
        // 1 - multiple choice, 2 - mathcing, 3 - fill in the blank
        if (questionType == 1) {
            return questions.get(0);
        } else if (questionType == 2) {
            return questions.get(1);
        } else {
            return questions.get(2);
        }
    }

    public boolean getComplete(){
        return true;
    }

    public void setComplete(Boolean booL){
        
    }
}
