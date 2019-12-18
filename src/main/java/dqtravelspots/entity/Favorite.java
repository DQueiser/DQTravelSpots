package dqtravelspots.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * The type Favorite.
 */
@Entity(name = "Favorite")
@Table(name = "favorites")
public class Favorite {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;

    @ManyToOne
    private User user;

    @Column(name = "spot_id")
    private String spotID;

    @Column(name = "date_registered")
    private Date dateRegistered;


    /**
     * Instantiates a new Favorite.
     */
    public Favorite() {
    }

    /**
     * Instantiates a new Favorite.
     * @param user
     * @param spotID
     * @param dateRegistered
     */
    public Favorite(User user, String spotID, Date dateRegistered) {
        this.user = user;
        this.spotID = spotID;
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
     * Gets user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Gets spot ID.
     *
     * @return the spot ID
     */
    public String getSpotID() {
        return spotID;
    }

    /**
     * Sets spot ID.
     *
     * @param spotID the spot ID
     */
    public void setSpotID(String spotID) {
        this.spotID = spotID;
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

}
