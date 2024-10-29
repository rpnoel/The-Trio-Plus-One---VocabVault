package model;
import java.util.ArrayList;
import java.util.Iterator;

public class Level {
    private ArrayList<Question> questions;
    private int levelNum;
    private int qNum = 0; //number of questions

    public Level(int levelNum, Book sourceBook) {
        this.levelNum = levelNum;
        this.questions = new ArrayList<>();
        populateQ(sourceBook);
    }

    private void populateQ(Book sourceBook) {
        ArrayList<Word> vocabWords = sourceBook.getVocabWords();
        Iterator<Word> iterator = vocabWords.iterator();
        while (iterator.hasNext()) {
            Word word = iterator.next();
            questions.add(generateQ(word,true,word.getTranslation()));
            iterator.remove();
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
            Question temp = questions.get(0);
            questions.remove(temp);
            return temp;
        } else if (questionType == 2) {
            Question temp = questions.get(1);
            questions.remove(temp);
            return temp;
        } else if (questionType == 3) {
            Question temp = questions.get(2);
            questions.remove(temp);
            return temp;
        } else {
            Question temp = questions.get(4);
            questions.remove(temp);
            return temp;
        }
    }

    public boolean getComplete(){
        return true;
    }

    public void setComplete(Boolean booL){
        
    }

}
