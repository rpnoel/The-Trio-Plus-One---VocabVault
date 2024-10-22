import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DataLoader extends DataConstants{

    public static ArrayList<User> getUsers() { 
        ArrayList<User> users = new ArrayList<User>();
        
        try {
            FileReader reader = new FileReader(USER_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray usersJSON = (JSONArray)new JSONParser().parse(reader);

            for(int i=0; i < usersJSON.size(); i++) {
                JSONObject userJSON = (JSONObject)usersJSON.get(i);
            
                String userName = (String)userJSON.get(USERNAME);
                String email = (String)userJSON.get(EMAIL);
                String firstName = (String)userJSON.get(FIRST_NAME);
                String lastName = (String)userJSON.get(LAST_NAME);
                String password = (String)userJSON.get(PASSWORD);
                users.add(new User(userName, email, firstName, lastName, password));
           }

            return users;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {
        ArrayList<User> users = getUsers();
        for(User user : users){
            System.out.println(user.getUsername() + " " + user.getEmail());
        }
    }
}
