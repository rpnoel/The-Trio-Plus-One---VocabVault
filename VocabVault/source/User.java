import java.util.ArrayList;

public class User {
    private String username;
    private String email;
    private Rank rank;

    public User(String username, String email){
        this.username = username;
        this.email = email;
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


}
