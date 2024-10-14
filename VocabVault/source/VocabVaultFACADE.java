public class VocabVaultFACADE {
    private User user;
    private UserList userList;

    public VocabVaultFACADE(){
        userList = UserList.getInstance();
    }

    public boolean login(String userName){
        if(!userList.haveUser(userName))return false;
		
		User currentUser = userList.getUser(userName);
		return true;
    }

    public boolean add(String userName, String email, String firstName, String lastName){
        if(userList.haveUser(userName))return false;
            
        boolean newUser = userList.addUser(userName, email, firstName, lastName);
        DataWriter.saveUsers();
        return true;
        }
    }

