import java.util.ArrayList;

public class Level {
    private ArrayList<Question> questions;
    private boolean complete;
    private int levelNum;

    public Level(int levelNum){

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
