package model;
public class leveltester {
    public static void main(String[] args) {
        BookReader reader = new BookReader("VocabVault\\txt\\goldilocksESP.txt");
        Level level = new Level(1, reader.getBook());
    }
}
