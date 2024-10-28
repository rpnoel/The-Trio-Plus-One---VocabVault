package model;
import java.util.ArrayList;

public class Level {
    private ArrayList<Question> questions;
    private boolean complete;
    private int levelNum;
    private int qNum; //number of questions

    public Level(int levelNum, int qNum, Book sourceBook){
        this.levelNum = levelNum;
        this.qNum = qNum;
        this.questions = new ArrayList<>();

        ArrayList<Word> vocabWords = sourceBook.getVocabWords();
        for (int i = 0; i < qNum && i < vocabWords.size(); i++) {
            Word word = vocabWords.get(i);
            boolean trueFalseAnswer = true; 
            String correctAnswer = "Correct Answer"; 
            questions.add(generateQ(word, trueFalseAnswer, correctAnswer));
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

    public static void main(String[] args) {
        BookReader bookReader = new BookReader("VocabVault\\txt\\goldilocksESP.txt"); 
        Book sourceBook = bookReader.book;
        Level newLevel = new Level(1, 5, sourceBook);
    }
}
