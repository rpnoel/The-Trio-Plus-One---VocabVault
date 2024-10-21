import java.util.ArrayList;
import java.util.UUID;

public class User {
    private UUID userID;
    private String username;
    private String email;
    private Rank rank;
    private int points;
    private ArrayList<Language> languages;
    private StoryMode userProgress;
    private String firstName;
    private String lastName;
    private String password;

    public User(String username, String email, String firstName, String lastName, String password){
        this.userID = UUID.randomUUID();
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    public User(UUID userID, String username, String email, String firstName, String lastName, String password){
        this.userID = userID;
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    public String getUsername(){
        return username;
    }

    public Rank getRank(){
        return rank;
    }

    public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

    public void addPoints(int points){

    }

    public void RegisteredUser(String firstName, String lastName, String userName, String email, String language){
        
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password= password;
    }

    public boolean checkPassword(String password){
        return this.password.equals(password);
    }

    public UUID getUserId(){
        return userID;
    }

    public void setUserId(UUID userID){
        this.userID= userID;
    }
    


}
