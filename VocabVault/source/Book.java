//@author Max Granger
import java.util.ArrayList;

public class Book {
    private String title;
    private String text;
    private ArrayList<Word> vocabWords;

    public Book(String title, String text, ArrayList<Word> vocabWords) {
        this.title = title;
        this.text = text;
        this.vocabWords = vocabWords;
    }

    public String getTitle() {
        return this.title;
    }

    public String getText() {
        return this.text;
    }

    public ArrayList<Word> getVocabWords() {
        return this.vocabWords;
    }
}
