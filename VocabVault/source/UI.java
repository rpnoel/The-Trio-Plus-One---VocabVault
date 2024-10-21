import java.util.Scanner;

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
        if(!checkUser){
            System.err.println("Error: This user already exists");
        }
        else if(!email.contains("@")){
            System.err.println("Error: Email is not valid");
        }
        else if(password.length() < 8){
            System.err.println("Error: Password must be at least 8 characters");
        }
        else{
            System.err.println("Welcome, " + newUser + "!");
        }
    }

    public void currentScenario(){
        if(facade.getCurrentUser() == null){
            System.out.println("No user is currently logged in");
        }
        System.out.println("The current user logged in is "+ facade.getCurrentUser());
    }

    public void logoutScenario(){
        facade.logout();
    }
    public static void main(String[] args) {
        UI ui = new UI(); 
        ui.addScenario();
}
}

