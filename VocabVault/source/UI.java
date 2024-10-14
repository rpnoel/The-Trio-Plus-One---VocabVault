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
        System.out.println("Please enter your username");
        String username = scanner.nextLine();
        facade.login(username);
        if(!facade.login(username)){
            System.err.println("This user does not exist");
        }
        else{
            System.err.println("Welcome back!");
        }
    }

    public void addScenario(){
        System.out.println("Please create an account");
        String newUser = scanner.nextLine();
        String email = scanner.nextLine();
        String firstName = scanner.nextLine();
        String lastName = scanner.nextLine();
        facade.add(newUser, email, firstName, lastName);
        if(!facade.add(newUser, email, firstName, lastName)){
            System.err.println("This user already exists");
        }
        else{
            System.err.println("Welcome, " + newUser + "!");
        }
    }
    public static void main(String[] args) {
        UI ui = new UI(); 
        ui.addScenario();
        ui.loginScenario(); 
}
}

