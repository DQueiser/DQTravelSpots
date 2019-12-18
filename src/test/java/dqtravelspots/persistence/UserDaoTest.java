package dqtravelspots.persistence;

import dqtravelspots.entity.User;
import dqtravelspots.entity.Usertrip;
import dqtravelspots.entity.Pointofinterest;
import dqtravelspots.testUtils.Database;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class UserDaoTest {

    GenericDao dao;

    /**
     * Run set up tasks before each test:
     * 1. execute sql which deletes everything from the table and inserts records)
     * 2. Create any objects needed in the tests
     */
    @BeforeEach
    void setUp() {
        dao = new GenericDao(User.class);
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    /**
     * Verify successful retrieval of a User
     */
    @Test
    void getByIdSuccess() {
        User retrievedUser = (User) dao.getById(1);
        //User retrievedUser = dao.getById(1);
        assertEquals("Dave", retrievedUser.getFirstName());
        assertEquals("Queiser", retrievedUser.getLastName());
    }

    /**
     * Verify successful update of a User
     */
    @Test
    void updateSuccess() {
        String newFirstName = "Artemis";
        User userToUpdate = (User) dao.getById(1);
        userToUpdate.setFirstName(newFirstName);
        dao.saveOrUpdate(userToUpdate);
        User userAfterUpdate = (User) dao.getById(1);
        assertEquals(newFirstName, userAfterUpdate.getFirstName());
    }

    /**
     * Verify successful insert of an Author
     */
    @Test
    void insertSuccess() {
        Date today = new Date();
        User newUser = new User("Artemis", "Jimmers", "ajimmers@gmail.com", "ajimmers", "supersecret2", today);
        int id = dao.insert(newUser);
        assertNotEquals(0, id);
        User insertedUser = (User) dao.getById(id);
        assertNotNull(insertedUser);
        assertEquals("Jimmers", insertedUser.getLastName());
        //Could continue comparing all values, but
        //it may make sense to use .equals()
    }

    /**
     * Verify successful insert of a user and a trip
     */
    @Test
    void insertWithTripSuccess() {
        String newUserFirst = "Dave";
        String newUserLast = "Bowman";
        String newUserEmail = "dbowman@yahoo.com";
        String newUserUname = "dbowman1";
        String newUserPassword = "Supersecret2!";
        String tripCityLoc = "MILWWI";
        int tripCount = 6;
        String tripRating = "5";
        String tripComment = "Definitely worth a second look";
        Date today = new Date();
        User newUser = new User(newUserFirst, newUserLast, newUserEmail, newUserUname, newUserPassword, today);
        //Usertrip newUserTrip = new Usertrip(newUser, tripCityLoc, tripCount, tripRating, tripComment, today);
        //newUser.addTrip(newUserTrip);
        //int id = dao.insert(newUser);
        //assertNotEquals(0, id);
        //User insertedUser = (User) dao.getById(id);
        //assertNotNull(insertedUser);
        //assertEquals("dbowman1", insertedUser.getUserName());
        //assertEquals(1, insertedUser.getUsertrips().size());

    }

    /**
     * Verify successful delete of Author
     */
    @Test
    void deleteSuccess() {
        dao.delete(dao.getById(2));
        assertNull(dao.getById(2));
    }

    /**
     * Verify successful retrieval of all Users
     */
    @Test
    void getAllSuccess() {
        List<User> Users = dao.getAll();
        assertEquals(2, Users.size());
    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<User> users = dao.findByPropertyEqual("firstName", "Mark");
        assertEquals(1, users.size());
        assertEquals(2, users.get(0).getId());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<User> users = dao.findAllByPropertyLike("lastName", "Q");
        assertEquals(1, users.size());
    }
}



