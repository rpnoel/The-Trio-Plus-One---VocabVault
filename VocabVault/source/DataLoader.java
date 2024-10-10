import java.io.FileReader;
import java.util.ArrayList;
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
                users.add(new User(userName, email));
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
