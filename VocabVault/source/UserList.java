import java.util.ArrayList;

public class UserList {
    private static UserList users;
	private static ArrayList<User> userList;

    private UserList(){
        userList = DataLoader.getUsers();
    }

    public static UserList getInstance(){
        if (userList == null) {
            users = new UserList();
        }
        return users;
    }

public void addUser(String username, String email){
    userList.add(new User(username, email));
}

    public ArrayList<User>getUsers(){
        return userList;
    }

}
