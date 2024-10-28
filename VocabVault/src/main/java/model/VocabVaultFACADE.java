package model;
import java.util.ArrayList;

public class VocabVaultFACADE {
    private User user;
    private UserList userList;
    private User currentUser;
    private UserProgressTracker usrProg;
    private Level newLevel;

    public VocabVaultFACADE(){
        userList = UserList.getInstance();
    }

    public boolean login(String userName, String password){
        if(!userList.haveUser(userName))return false;
		currentUser = userList.getUser(userName);
        if(currentUser == null) return false;
        if (!currentUser.checkPassword(password)) return false;
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
    }

    public void checkProg(){
        UserProgressTracker usrProg = new UserProgressTracker(currentUser);
        usrProg.displayProgress();
    }

    public Level loadLevel(){
        Level newLevel = new Level(0, 0, null)
    }
    }

