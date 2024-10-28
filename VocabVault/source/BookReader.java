//@author Max Granger
import java.io.FileReader;

public class BookReader {
    public Book book;
    public FileReader reader;
    
    public BookReader(String fileName) {
        try {
            reader = new FileReader(fileName);
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
