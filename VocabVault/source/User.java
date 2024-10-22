import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

/* CHange */
public class User {
    private UUID userID; // Unique identifier for the user
    private String username; // Username of the user
    private String email; // Email of the user
    private Rank rank; // User's rank
    private int points; // User's points
    private ArrayList<Language> languages; // List of languages the user is learning
    private StoryMode userProgress; // User's progress in story mode
    private ArrayList<Cosmetic> cosmetics; // User's cosmetic items
    private ArrayList<PowerUp> powerUps; // User's power-ups
    private String firstName; // User's first name
    private String lastName; // User's last name
    private HashMap<LeagueType, Rank> rankList; // List of ranks based on league

    /**
     * Constructor to create a new user with basic information.
     * A new unique UUID is generated for each user.
     *
     * @param username 
     * @param email     
     * @param firstName 
     * @param lastName  
     */
    public User(String username, String email, String firstName, String lastName) {
        this.userID = UUID.randomUUID();
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.points = 0;
        this.languages = new ArrayList<>();
        this.cosmetics = new ArrayList<>();
        this.powerUps = new ArrayList<>();
        this.rankList = new HashMap<>();
    }

    /**
     * Constructor to create a new user with a specified UUID.
     * This is useful when restoring users from a saved state.
     *
     * @param userID    The unique ID of the user
     * @param username  The username of the user
     * @param email     The email of the user
     * @param firstName The user's first name
     * @param lastName  The user's last name
     */
    public User(UUID userID, String username, String email, String firstName, String lastName) {
        this.userID = userID;
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.points = 0;
        this.languages = new ArrayList<>();
        this.cosmetics = new ArrayList<>();
        this.powerUps = new ArrayList<>();
        this.rankList = new HashMap<>();
    }

    /**
     * Gets the unique user ID.
     *
     * @return The user's unique ID.
     */
    public UUID getId() {
        return userID;
    }

    /**
     * Gets the username of the user.
     *
     * @return The user's username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets the rank of the user.
     *
     * @return The user's current rank.
     */
    public Rank getRank() {
        return rank;
    }

    /**
     * Gets the email of the user.
     *
     * @return The user's email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets a new email for the user.
     *
     * @param email The new email to be set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Adds points to the user's total points.
     *
     * @param points The number of points to add.
     */
    public void addPoints(int points) {
        this.points += points;
    }

    /**
     * Gets the first name of the user.
     *
     * @return The user's first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the user.
     *
     * @param firstName The user's first name to be set.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name of the user.
     *
     * @return The user's last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the user.
     *
     * @param lastName The user's last name to be set.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Adds a language to the user's list of languages.
     *
     * @param language The language to be added.
     */
    public void addLanguage(Language language) {
        this.languages.add(language);
    }

    /**
     * Adds a cosmetic item to the user's inventory.
     *
     * @param cosmetic The cosmetic item to be added.
     */
    public void addCosmetic(Cosmetic cosmetic) {
        this.cosmetics.add(cosmetic);
    }

    /**
     * Adds a power-up to the user's inventory.
     *
     * @param powerUp The power-up to be added.
     */
    public void addPowerUp(PowerUp powerUp) {
        this.powerUps.add(powerUp);
    }

    /**
     * Gets the user's inventory of cosmetic items.
     *
     * @return The list of cosmetics the user owns.
     */
    public ArrayList<Cosmetic> getCosmetics() {
        return cosmetics;
    }

    /**
     * Gets the user's inventory of power-ups.
     *
     * @return The list of power-ups the user owns.
     */
    public ArrayList<PowerUp> getPowerUps() {
        return powerUps;
    }

    /**
     * Gets the list of ranks for different league types.
     *
     * @return A map of league types to ranks.
     */
    public HashMap<LeagueType, Rank> getRankList() {
        return rankList;
    }

    /**
     * Sets the rank for a particular league type.
     *
     * @param league The league type.
     * @param rank   The rank to be set for the league.
     */
    public void setRank(LeagueType league, Rank rank) {
        this.rankList.put(league, rank);
    }
}

