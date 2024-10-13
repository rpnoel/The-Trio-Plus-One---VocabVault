public class Question {
    private String questionText;
    private ArrayList<String> choices;
    private String correctAnswer;
    private QuestionType questionType;

    public boolean checkAnswer(String answer){
        if (answer.equals(correctAnswer){
            return true;
        } else {
            return false;
        }
    }

    public void setCorrectAnswer(String correctAnswer){
        this.correctAnswer = correctAnswer;
    }

    public ArrayList<String> getChoices(){
        return choices;
    }

    public String getCorrectAnswer(){
        return correctAnswer;
    }
}
