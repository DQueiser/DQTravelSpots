package dqtravelspots.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * The type Usertrip.
 */
@Entity(name = "Usertrip")
@Table(name = "usertrips") // case sensitive!
public class Usertrip {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;

    @Column(name = "citylocationcode")
    private String cityLocation;

    @Column(name = "rating")
    private String rating;

    @Column(name = "comment")
    private String comment;

    @Column(name = "date_registered")
    private Date dateRegistered;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "usertrip", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Pointofinterest> Pointsofinterest = new HashSet<>();


    /**
     * Instantiates a new Usertrip.
     */
    public Usertrip() {
    }

    /**
     * Instantiates a new Usertrip.
     * @param user
     * @param cityLocation
     * @param rating
     * @param comment
     * @param dateRegistered
     */
    public Usertrip(User user, String cityLocation, String rating, String comment, Date dateRegistered) {
        this.user = user;
        this.cityLocation = cityLocation;
        this.rating = rating;
        this.comment = comment;
        this.dateRegistered = dateRegistered;
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
     * Gets city location.
     *
     * @return the city location
     */
    public String getCityLocation() {
        return cityLocation;
    }

    /**
     * Sets city location.
     *
     * @param cityLocation the city location
     */
    public void setCityLocation(String cityLocation) {
        this.cityLocation = cityLocation;
    }

    /**
     * Gets rating.
     *
     * @return the rating
     */
    public String getRating() {
        return rating;
    }

    /**
     * Sets rating.
     *
     * @param rating the rating
     */
    public void setRating(String rating) {
        this.rating = rating;
    }

    /**
     * Gets comment.
     *
     * @return the comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * Sets comment.
     *
     * @param comment the comment
     */
    public void setComment(String comment) {
        this.comment = comment;
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
     * Gets points of interest.
     *
     * @return the points of interest
     */
    public Set<Pointofinterest> getPointsofinterest() {
        return Pointsofinterest;
    }

    /**
     * Sets points of interest.
     *
     * @param pointOfInterest the points of interest
     */
    public void setPointsofinterest(Set<Pointofinterest> pointOfInterest) {
        this.Pointsofinterest = pointOfInterest;
    }

    /**
     * Add a point of interest.
     *
     * @param pointOfInterest the point of interest to add
     */
    public void addPointOfInterest(Pointofinterest pointOfInterest) {
        Pointsofinterest.add(pointOfInterest);
        pointOfInterest.setUsertrip(this);
    }

    /**
     * Remove a point of interest.
     *
     * @param pointOfInterest the trip to remove
     */
    public void removeTrip(Pointofinterest pointOfInterest) {
        Pointsofinterest.remove(pointOfInterest);
        pointOfInterest.setUsertrip(null);
    }

}
