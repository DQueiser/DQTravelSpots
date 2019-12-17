package dqtravelspots.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * The type Touristspot.
 */
@Entity(name = "Touristspot")
@Table(name = "touristspot")
public class Touristspot {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;

    @Column(name = "planet_id")
    private String planetID;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "handicap")
    private String handicapAccess;

    @Column(name = "imperial")
    private String imperialOnly;

    @Column(name = "date_registered")
    private Date dateRegistered;


    /**
     * Instantiates a new Touristspot.
     */
    public Touristspot() {
    }

    /**
     * Instantiates a new Touristspot.
     * @param planetID
     * @param name
     * @param description
     * @param handicapAccess
     * @param imperialOnly
     * @param dateRegistered
     */
    public Touristspot(String planetID, String name, String description, String handicapAccess, String imperialOnly, Date dateRegistered) {
        this.planetID = planetID;
        this.name = name;
        this.description = description;
        this.handicapAccess = handicapAccess;
        this.imperialOnly = imperialOnly;
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
     * Gets planet ID.
     *
     * @return the planet ID
     */
    public String getPlanetID() {
        return planetID;
    }

    /**
     * Sets planet ID.
     *
     * @param planetID the planet ID
     */
    public void setPlanetID(String planetID) {
        this.planetID = planetID;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
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
     * Gets handicap access.
     *
     * @return the handicapAccess
     */
    public String getHandicapAccess() {
        return handicapAccess;
    }

    /**
     * Sets handicap access.
     *
     * @param handicapAccess the handicap access
     */
    public void setHandicapAccess(String handicapAccess) {
        this.handicapAccess = handicapAccess;
    }

    /**
     * Gets imperial only access.
     *
     * @return the imperialOnly
     */
    public String getImperialOnly() {
        return imperialOnly;
    }

    /**
     * Sets imperial only access.
     *
     * @param imperialOnly the imperial only access
     */
    public void setImperialOnly(String imperialOnly) {
        this.imperialOnly = imperialOnly;
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
