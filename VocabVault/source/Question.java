//@author Max Granger

public class Question {
<<<<<<< HEAD:source/Question.java
    
=======
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
>>>>>>> 1ac1eb9fde433b501bc3562a7b7412988a853233:VocabVault/source/Question.java
}
