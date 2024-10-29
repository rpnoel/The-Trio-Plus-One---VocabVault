package model;
import java.util.Scanner;

public class LevelDriver {
    public static void main(String[] args) {
        BookReader reader = new BookReader("txt/goldilocksESP.txt");
        Scanner scan = new Scanner(System.in);
        Level level = new Level(1, reader.getBook());
        for (int i = 0; i < 12; i++) {
            if (i % 4 == 0) {
                //implelemt true/false game correct answer
                System.out.println("Skip");
            } else if (i % 3 == 0) {
                Question currQ = level.getQuestion(3);
                System.out.println(currQ.toString());
                String userInput = scan.nextLine();
                Boolean corr = currQ.checkAnswer(userInput);
                level.score(corr);
            } else if (i % 2 == 0) {
                //implement matching game correct answer
                System.out.println("Skip");
            } else {
                Question currQ = level.getQuestion(1);
                System.out.println(currQ.toString());
                String userInput = scan.nextLine();
                Boolean corr = currQ.checkAnswer(userInput);
                level.score(corr);
            }
        }
        System.out.println("Your score: " + level.getScore() + " / " + level.getQNum());
    }
}
