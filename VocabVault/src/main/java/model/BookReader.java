package model;

//@author Max Granger
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.StringBuilder;
import java.util.ArrayList;

public class BookReader {
    public Book book;
    
    public BookReader(String fileName) {
        ArrayList<Word> vocabWords = new ArrayList<Word>();
        String title = "";
        StringBuilder bodyText = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            if (line != null) {
                String[] words = line.split(",");
                for (int i = 0; i < words.length - 1; i += 2) {
                    vocabWords.add(new Word(words[i], words[i + 1]));
                }
            }
            title = reader.readLine();
            String line2 = reader.readLine();
            while ((line2 = reader.readLine()) != null) {
                bodyText.append(line2).append("\n");
            }
            this.book = new Book(title, bodyText.toString(), vocabWords);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Book getBook() {
        return this.book;
    }

    @Override
    public String toString() {
        if (book != null) {
            return "Title: " + book.getTitle() + "\nBody:\n" + book.getText() + "\nVocabulary Words:\n" + book.getVocabWords();
        } else {
            return "No book data available.";
        }
    }
    public static void main(String[] args) {

    }
}

