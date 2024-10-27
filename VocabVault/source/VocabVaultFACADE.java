import java.util.ArrayList;

public class VocabVaultFACADE {
    private User user;
    private UserList userList;
    private User currentUser;

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
            return true;
        }
            return false;
        }

    public String getCurrentUser(){
        return currentUser.getUsername();
    }

    public ArrayList<Language> currentLanguages(){
        return currentUser.getLanguages();
    }

    public void logout(){
        //TODO: Print Goodbye based on Language being studied
        System.out.println("Goodbye, " + getCurrentUser() + "!");
        currentUser = null;
    }
    }

