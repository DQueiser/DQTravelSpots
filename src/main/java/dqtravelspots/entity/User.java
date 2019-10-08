package dqtravelspots.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.Date;

@Entity(name = "User")
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "date_registered")
    private Date dateRegistered;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Usertrip> Usertrips = new HashSet<>();

    /**
     * Instantiates a new User.
     */
    public User() {
    }

    public User(String firstName, String lastName, String email, String userName, String password, Date dateRegistered) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.dateRegistered = dateRegistered;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets email address.
     *
     * @return the email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email address.
     *
     * @param email the email address
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets user name.
     *
     * @return the user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets user name.
     *
     * @param userName the user name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets date registered.
     *
     * @return the date registered
     */
    public Date getDateRegistered() {
        return dateRegistered;
    }

    /**
     * Sets date registered.
     *
     * @param dateRegistered the date registered
     */
    public void setDateRegistered(Date dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    /**
     * Gets user trips.
     *
     * @return the user trips
     */
    public Set<Usertrip> getUsertrips() {
        return Usertrips;
    }

    /**
     * Sets user trips.
     *
     * @param userTrips the user trips
     */
    public void setUsertrips(Set<Usertrip> userTrips) {
        this.Usertrips = userTrips;
    }

    /**
     * Add a user trip.
     *
     * @param userTrip the trip to add
     */
    public void addTrip(Usertrip userTrip) {
        Usertrips.add(userTrip);
        userTrip.setUser(this);
    }

    /**
     * Remove a user trip.
     *
     * @param userTrip the trip to remove
     */
    public void removeTrip(Usertrip userTrip) {
        Usertrips.remove(userTrip);
        userTrip.setUser(null);
    }
}
