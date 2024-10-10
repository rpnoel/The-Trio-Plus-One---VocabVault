import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants {
	
	
	public static void saveUsers() {
		UserList users = UserList.getInstance();
		ArrayList<User> userList = users.getUsers();
		JSONArray jsonFriends = new JSONArray();
		
		for(int i=0; i< userList.size(); i++) {
			jsonFriends.add(getUserJSON(userList.get(i)));
		}
		
        try (FileWriter file = new FileWriter(USER_FILE_NAME)) {
            file.write(jsonFriends.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static JSONObject getUserJSON(User user) {
		JSONObject userDetails = new JSONObject();
		userDetails.put(USERNAME, user.getUsername());
		userDetails.put(EMAIL, user.getEmail());
        return userDetails;
	}

    public static void main(String[] args) {
        DataWriter.saveUsers();
    }
}