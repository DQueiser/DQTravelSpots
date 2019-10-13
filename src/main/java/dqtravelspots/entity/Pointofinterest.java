package dqtravelspots.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * The type Pointofinterest.
 */
@Entity(name = "Pointofinterest")
@Table(name = "pointofinteresr")
public class Pointofinterest {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;

    @Column(name = "citylocationcode")
    private String cityLocation;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "comment")
    private String comment;

    @Column(name = "url")
    private String url;

    @Column(name = "date_registered")
    private Date dateRegistered;

    @ManyToOne
    private Usertrip usertrip;


    /**
     * Instantiates a new Pointofinterest.
     */
    public Pointofinterest() {
    }

    /**
     * Instantiates a new Pointofinterest.
     * @param userTrip
     * @param cityLocation
     * @param title
     * @param description
     * @param comment
     * @param url
     * @param dateRegistered
     */
    public Usertrip(Usertrip userTrip, String cityLocation, String title, String description, String comment, String url, Date dateRegistered) {
        this.usertrip = userTrip;
        this.cityLocation = cityLocation;
        this.title = title;
        this.description = description;
        this.comment = comment;
        this.url = url;
        this.dateRegistered = dateRegistered;
    }

    /**
     * Gets usertrip.
     *
     * @return the usertrip
     */
    public Usertrip getUsertrip() {
        return usertrip;
    }

    /**
     * Sets usertrip.
     *
     * @param userTrip the user
     */
    public void setUsertrip(Usertrip userTrip) {
        this.usertrip = userTrip;
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
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets title.
     *
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
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
     * Gets url.
     *
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets url.
     *
     * @param url the url
     */
    public void setUrl(String url) {
        this.url = url;
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
