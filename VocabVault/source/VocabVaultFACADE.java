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
        if(userList.haveUser(userName))return false;
            
        boolean newUser = userList.addUser(userName, email, firstName, lastName, password);
        DataWriter.saveUsers();
        return true;
        }

    public String getCurrentUser(){
        return currentUser.getUsername();
    }

    public void logout(){
        currentUser = null;
    }
    }

