import java.util.ArrayList;

public class DataLoader {
private user UserList;

    public ArrayList<User> getUser(){
        return UserList;
    }

    public static void main(String[] args) {
        DataLoader testLoader = new DataLoader();
        testLoader.getUsers();
    }
}
