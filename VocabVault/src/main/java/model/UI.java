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
        BookReader read = new BookReader("VocabVault\\txt\\POLLYgoldilocksESP.txt");
        System.out.println(read);
        Narriator.playSound(read.book.getText());
        }
    }

    public void play(){
        facade.play();
    }
    

    public static void main(String[] args) {
        UI ui = new UI();
        Scanner keyboard = new Scanner(System.in);
        int userInput = -1;
    
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
    
            // Check if next input is an integer
            if (keyboard.hasNextInt()) {
                userInput = keyboard.nextInt();
                keyboard.nextLine(); // Consume newline left after nextInt()
    
                switch (userInput) {
                    case 1 -> ui.addScenario();
                    case 2 -> ui.loginScenario();
                    case 3 -> ui.currentScenario();
                    case 4 -> ui.logoutScenario();
                    case 5 -> ui.checkProg();
                    case 6 -> ui.study();
                    case 7 -> ui.play();
                    case 0 -> System.out.println("Exiting...");
                    default -> System.out.println("Invalid option, please try again.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                keyboard.next(); // Clear the invalid input
            }
        }
    
        keyboard.close();
    }
}

