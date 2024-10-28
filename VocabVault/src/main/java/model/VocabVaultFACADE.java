package model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class VocabVaultFACADE {
    private User user;
    private UserList userList;
    private User currentUser;
    private UserProgressTracker usrProg;

    public VocabVaultFACADE(){
        userList = UserList.getInstance();
    }

    public boolean login(String userName, String password){
        if (!userList.haveUser(userName)) return false;
        currentUser = userList.getUser(userName);
        if (currentUser == null || !currentUser.checkPassword(password)) return false;
        
        // Initialize usrProg after successful login
        usrProg = new UserProgressTracker(currentUser);
        return true;
    }

    public boolean add(String userName, String email, String firstName, String lastName, String password){
        if(userList.haveUser(userName)){
            System.err.println("Error: This user already exists");
            return false;
        }
        else if(!email.contains("@") || !email.contains(".com")){
            System.err.println("Error: Email is not valid");
            return false;
        }
        else if(password.length() < 8){
            System.err.println("Error: Password must be at least 8 characters");
            return false;
        }
        else if(password.contains(userName)){
            System.err.println("Error: Password cannot include Username");
            return false;
        }
        boolean newUser = userList.addUser(userName, email, firstName, lastName, password);
        if(newUser){
            DataWriter.saveUsers();
            currentUser = userList.getUser(userName);
            usrProg = new UserProgressTracker(currentUser);
            return true;
        }
            return false;
        }

        public String getCurrentUser() {
            if (currentUser == null) {
                return "Empty";
            }
            return currentUser.getUsername();
        }
        

    public void logout(){
        System.out.println("Goodbye, " + getCurrentUser() + "!");
        currentUser = null;
        usrProg = null;
    }

    public void checkProg() {
        if (usrProg != null) {
            usrProg.displayProgress();
        } else {
            System.out.println("No progress data available.");
        }
    }

    public void play() {
        if (usrProg == null) {
            System.err.println("Please log in to play.");
            return;
        }
        BookReader reader = new BookReader("VocabVault\\txt\\goldilocksESP.txt");
        Level level = new Level(1, reader.getBook());
        Scanner keyboard = new Scanner(System.in);
    
        List<Integer> questionOrder = new ArrayList<>(List.of(0, 1, 2, 3));
        Collections.shuffle(questionOrder);
    
        for (int i = 0; i < 4; i++) {
            int questionType = questionOrder.get(i) + 1;
            Question question = level.getQuestion(questionType);
            System.out.println(question.toString());
    
            System.out.print("Your answer: ");
            String userAnswer = keyboard.nextLine();
    
            boolean isCorrect = false;
    
            if (questionType == 1 && question instanceof MultipleChoice) {
                System.out.println("Correct answer: " + ((MultipleChoice) question).getCorrectAnswerText());
                isCorrect = userAnswer.equals(((MultipleChoice) question).getCorrectAnswerText());
            } else if (questionType == 2 && question instanceof Matching) {
                System.out.println("Correct answer: " + ((Matching) question).getCorrectAnswer());
                isCorrect = userAnswer.equals(((Matching) question).getCorrectAnswer());
            } else if (questionType == 3 && question instanceof FillInTheBlank) {
                System.out.println("Correct answer: " + ((FillInTheBlank) question).getCorrAnswer());
                isCorrect = userAnswer.equals(((FillInTheBlank) question).getCorrAnswer());
            } else if (questionType == 4 && question instanceof TrueFalse) {
                boolean correctAnswer = ((TrueFalse) question).checkAnswer(userAnswer);
                System.out.println("Correct answer: " + correctAnswer);
                isCorrect = Boolean.toString(correctAnswer).equalsIgnoreCase(userAnswer);
            }
    
            usrProg.logAnswer(question, isCorrect);
        }
    
    }
}
    

    

