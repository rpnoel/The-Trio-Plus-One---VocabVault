package VocabVault.source;

//@author Max Granger

public enum Language {
    SPANISH("Spanish"),
    FRENCH("French"),
    GERMAN("German"),
    RUSSIAN("Russian"),
    JAPANESE("Japanese");

    public final String label;

    private Language(String label) {
        this.label = label;
    } 
}