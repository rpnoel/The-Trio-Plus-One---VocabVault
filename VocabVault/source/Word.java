public class Word {
    private String wordText;
    private char[] wordSpelling;
    private String wordPronunciation;
    private String translation;
    private Language language;

    public Word(String wordText, String translation, Language language) {
        this.wordText = wordText;
        char[] wordSpelling = new char[wordText.length()];
        for (int i = 0; i < wordText.length(); i++) {
            this.wordSpelling[i] = wordText.charAt(i);
        }
        this.translation = translation;
        this.language = language;
        this.wordPronunciation = null;//pronunciation to be implelemted later

    }

    public String getWordText(){
        return wordText;
    }

    public char[] getWordSpelling(){
        return wordSpelling;
    }

    public String getWordPronunciation(){
        return wordPronunciation;
    }
}
