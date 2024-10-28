package model;
import java.util.Scanner;

import com.narriation.Narriator;

public class UI {
    private Scanner scanner;
    private VocabVaultFACADE facade;
    private UserList userList;

    public UI() {
        this.scanner = new Scanner(System.in);
        this.facade = new VocabVaultFACADE();
        this.userList = UserList.getInstance();
    }

    public void loginScenario(){
        System.out.println("Welcome back to VocabVault!");
        System.out.println("Please enter your username");
        String username = scanner.nextLine();
        System.out.println("Please enter your password");
        String password = scanner.nextLine();
        facade.login(username, password);
        if(!facade.login(username, password)){
            System.err.println("Error: Invalid username or password");
        }
        else{
            System.err.println("Welcome back, " + username + "!");
        }
    }

    public void addScenario(){
        System.out.println("Let's make an account!");
        System.out.println("\nEnter your Username:");
        String newUser = scanner.nextLine();
        System.out.println("\nEnter your Email:");
        String email = scanner.nextLine();
        System.out.println("\nEnter your first name:");
        String firstName = scanner.nextLine();
        System.out.println("\nEnter your last name:");
        String lastName = scanner.nextLine();
        System.out.println("\nEnter a password:");
        String password = scanner.nextLine();
        boolean checkUser = facade.add(newUser, email, firstName, lastName, password);
        if(checkUser){
            System.err.println("Welcome, " + newUser + "!");        }
    }

    public void currentScenario() {
        String currentUser = facade.getCurrentUser();  
        if (currentUser != "Empty") {
            System.out.println("The current user logged in is " + currentUser);
        } else {
            System.err.println("No user is currently logged in");
        }
    }
    
    public void logoutScenario(){
        facade.logout();
    }

    public void checkProg(){
        facade.checkProg();
    }

    public void study(){
        System.out.println("Continue Reading?");
        String Userchoice = scanner.nextLine();
        if(Userchoice.equalsIgnoreCase("Yes")){
        BookReader read = new BookReader("VocabVault\\txt\\goldilocksESP.txt");
        System.out.println(read);
        Narriator.playSound(read.book.getText());
        }
    }

    public Level newLevel(){
    BookReader bookReader = new BookReader("VocabVault\\txt\\answerChoices.txt"); 
    Book sourceBook = bookReader.book;

    if (sourceBook != null) {
        return new Level(1, 5, sourceBook); 
    } else {
        System.err.println("Error: Book source could not be loaded for the level.");
        return null;  
    }
}
    

    public static void main(String[] args) {
        UI ui = new UI(); 
        Scanner keyboard = new Scanner(System.in);
        int userInput = -1;
        Level currentLevel = null;

        while (userInput != 0) {
            System.out.println("Choose an option:");
            System.out.println("1 - Create Account");
            System.out.println("2 - Login");
            System.out.println("3 - Current User");
            System.out.println("4 - Logout");
            System.out.println("5 - Progress");
            System.out.println("6 - Study");
            System.out.println("7 - Play");
            System.out.println("0 - Exit");
        userInput = keyboard.nextInt();
        switch (userInput) {
            case 1:
                ui.addScenario();
                break;    
            case 2:
                ui.loginScenario();
                break;
            case 3:
                ui.currentScenario();
                break;
            case 4:
                ui.logoutScenario();
                break;
            case 5:
                ui.checkProg();
                break;
            case 6:
                ui.study();
                break;
            case 7:
                ui.newLevel();
                if (currentLevel != null) {
                    System.out.println("New Level Started: " + currentLevel.getAllQuestions());
                }
                break;
            case 0:
            default:
                break;
        }
}
    }
}

