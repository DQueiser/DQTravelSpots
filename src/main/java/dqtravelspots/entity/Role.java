package dqtravelspots.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Role")
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;

    @Column(name = "role_name")
    private String roleName;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_id")
    private int userID;

    /**
     * Instantiates a new Role entry.
     */
    public Role() {
    }

    public Role(String roleName, String userName, int userID) {
        this.roleName = roleName;
        this.userName = userName;
        this.userID = userID;
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
     * Gets role name.
     *
     * @return the role name
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * Sets role name.
     *
     * @param roleName the role name
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
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
     * @param userName the last name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets user ID.
     *
     * @return the userID
     */
    public int getUserID() {
        return userID;
    }

    /**
     * Sets user ID.
     *
     * @param userID the use ID
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }
}
