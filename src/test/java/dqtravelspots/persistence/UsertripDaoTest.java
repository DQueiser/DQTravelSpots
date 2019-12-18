package dqtravelspots.persistence;

import dqtravelspots.entity.Pointofinterest;
import dqtravelspots.entity.User;
import dqtravelspots.entity.Usertrip;
import dqtravelspots.testUtils.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UsertripDaoTest {

    GenericDao dao;

    /**
     * Run set up tasks before each test:
     * 1. execute sql which deletes everything from the table and inserts records)
     * 2. Create any objects needed in the tests
     */
    @BeforeEach
    void setUp() {
        dao = new GenericDao(Usertrip.class);
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    /**
     * Verify successful retrieval of a Usertrip
     */
    @Test
    void getByIdSuccess() {
        Usertrip retrievedUsertrip = (Usertrip) dao.getById(1);
        assertEquals("ACIDPLANIT", retrievedUsertrip.getCityLocation());
        assertEquals("3", retrievedUsertrip.getRating());
    }

    /**
     * Verify successful update of a Usertrip
     */
    @Test
    void updateSuccess() {
        String newRating = "5";
        Usertrip usertripToUpdate = (Usertrip) dao.getById(1);
        usertripToUpdate.setRating(newRating);
        dao.saveOrUpdate(usertripToUpdate);
        Usertrip usertripAfterUpdate = (Usertrip) dao.getById(1);
        assertEquals(newRating, usertripAfterUpdate.getRating());
    }

    /**
     * Verify successful insert of a Usertrip
     */
    @Test
    void insertSuccess() {
        UserDao userDao = new UserDao();
        User user = userDao.getById(1);
        String newUTLocation = "ILCHI";
        int newUTNumPOI = 6;
        String newUTRating = "2";
        String newUTComment = "Wonderfully awesome, except for that traffic";
        Date today = new Date();
        //Usertrip newUserTrip = new Usertrip(user, newUTLocation, newUTNumPOI,newUTRating, newUTComment, today);
        //user.addTrip(newUserTrip);
        //int id = dao.insert(newUserTrip);
        //assertNotEquals(0, id);
        //Usertrip insertedUserTrip = (Usertrip) dao.getById(id);
        //assertNotNull(insertedUserTrip);
        //assertEquals(newUTLocation, insertedUserTrip.getCityLocation());
        //assertNotNull(insertedUserTrip.getUser());
        //assertEquals("Dave", insertedUserTrip.getUser().getFirstName());
    }

    /**
     * Verify successful insert of a usertrip and a pointofinterest
     */
    @Test
    void insertWithPOISuccess() {
        UserDao userDao = new UserDao();
        User user = userDao.getById(2);
        String newUTLocation = "CapeHatNC";
        int newUTNumPOI = 6;
        String newUTRating = "9";
        String newUTComment = "Lighthouses! Seafood! Fly a kite!!";
        String newPOITitle = "Wright Brothers Memorial";
        String newPOIDescription = "A blast of historic fun.";
        String newPOIComment = "7";
        String newPOIUrl = "www.imadethisup.edu";
        Date today = new Date();
        //Usertrip newUserTrip = new Usertrip(user, newUTLocation, newUTNumPOI, newUTRating, newUTComment, today);
        //Pointofinterest pointOfInterest = new Pointofinterest(newUserTrip,newUTLocation,newPOITitle,newPOIDescription, newPOIComment, newPOIUrl, today);
        //newUserTrip.addPointOfInterest(pointOfInterest);
        //int id = dao.insert(newUserTrip);
        //assertNotEquals(0, id);
        //Usertrip insertedUserTrip = (Usertrip) dao.getById(id);
        //assertNotNull(insertedUserTrip);
        //assertEquals(newUTLocation, insertedUserTrip.getCityLocation());
        //assertEquals(1, insertedUserTrip.getPointsofinterest().size());

    }

    /**
     * Verify successful delete of a usertrip
     */
    @Test
    void deleteSuccess() {
        dao.delete(dao.getById(1));
        assertNull(dao.getById(1));
    }

    /**
     * Verify successful retrieval of all Usertrips
     */
    //@Test
    //void getAllSuccess() {
        //List<Usertrip> Usertrips = dao.getAll();
        //assertEquals(1, Usertrips.size());
    //}

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<Usertrip> userTrips = dao.findByPropertyEqual("cityLocation", "ACIDPLANIT");
        assertEquals(1, userTrips.size());
        assertEquals(1, userTrips.get(0).getId());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<Usertrip> userTrips = dao.findAllByPropertyLike("rating", "3");
        assertEquals(1, userTrips.size());
    }
}



