package src.main.java.model;
import java.util.ArrayList;

public class Book {
    private String title;
    private String bookText;
    private ArrayList<Word> vocabWords;

    public Book(String title, String bookText, ArrayList<Word> vocabWords){
        this.title = title;
        this.bookText = bookText;
        this.vocabWords = vocabWords;
    }

    public String getTitle() {
        return this.title;
    }

    public String getText() {
        return this.bookText;
    }

    public ArrayList<Word> getVocabWords() {
        return this.vocabWords;
    }
}
