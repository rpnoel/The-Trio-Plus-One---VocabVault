package model;
import java.util.Scanner;

public class leveltester {
    public static void main(String[] args) {
        BookReader reader = new BookReader("txt/goldilocksESP.txt");
        Scanner scan = new Scanner(System.in);
        Level level = new Level(1, reader.getBook());
        for (int i = 0; i < 12; i++) {
            if (i % 4 == 0) {
                System.out.println(level.getQuestion(4).toString());
                String userInput = scan.nextLine();
            } else if (i % 3 == 0) {
                System.out.println(level.getQuestion(3).toString());
                String userInput = scan.nextLine();
                FillInTheBlank currQ = level.getQuestion(3);
            }
        }
    }
}
