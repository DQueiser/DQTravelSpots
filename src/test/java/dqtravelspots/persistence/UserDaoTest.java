package dqtravelspots.persistence;

import dqtravelspots.entity.User;
import dqtravelspots.entity.Usertrip;
import dqtravelspots.entity.Pointofinterest;
import dqtravelspots.testUtils.Database;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserDaoTest {

    UserDao dao;

    /**
     * Run set up tasks before each test:
     * 1. execute sql which deletes everything from the table and inserts records)
     * 2. Create any objects needed in the tests
     */
    @BeforeEach
    void setUp() {
        dao = new UserDao();
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    /**
     * Verify successful retrieval of a User
     */
    @Test
    void getByIdSuccess() {
        User retrievedUser = dao.getById(1);
        assertEquals("Dave", retrievedUser.getFirstName());
        assertEquals("Queiser", retrievedUser.getLastName());
    }

    /**
     * Verify successful update of an Author
     */
    //@Test
    //void updateSuccess() {
        //String newLastName = "Bates";
        //Author authorToUpdate = dao.getById(1);
        //authorToUpdate.setLastName(newLastName);
        //dao.saveOrUpdate(authorToUpdate);
        //Author authorAfterUpdate = dao.getById(1);
        //assertEquals(newLastName, authorAfterUpdate.getLastName());
    //}

    /**
     * Verify successful insert of an Author
     */
    //@Test
    //void insertSuccess() {
        //Author newAuthor = new Author("James", "Blaylock");
        //int id = dao.insert(newAuthor);
        //assertNotEquals(0, id);
        //Author insertedAuthor = dao.getById(id);
        //assertNotNull(insertedAuthor);
        //assertEquals("Blaylock", insertedAuthor.getLastName());
        // Could continue comparing all values, but
        // it may make sense to use .equals()

    }
    /**
     * Verify successful insert of an author and a book
     */
    //@Test
    //void insertWithBookSuccess() {
        //String newAuthorLast = "Blaylock";
        //String newAuthorFirst = "James";
        //String bookTitle = "The Last Coin";
        //String bookIsbn = "9789-112-1969";
        //int bookPubYear = 1988;
        //Author newAuthor = new Author(newAuthorFirst, newAuthorLast);
        //Book book = new Book(bookTitle,newAuthor,bookIsbn,bookPubYear);
        //newAuthor.addBook(book);
        //int id = dao.insert(newAuthor);
        //assertNotEquals(0, id);
        //Author insertedAuthor = dao.getById(id);
        //assertNotNull(insertedAuthor);
        //assertEquals("James", insertedAuthor.getFirstName());
        //assertEquals(1, insertedAuthor.getBooks().size());

    //}

    /**
     * Verify successful delete of Author
     */
    //@Test
    //void deleteSuccess() {
        //dao.delete(dao.getById(2));
        //assertNull(dao.getById(2));
    //}

    /**
     * Verify successful retrieval of all Authors
     */
    //@Test
    //void getAllSuccess() {
        //List<Author> Authors = dao.getAll();
        //assertEquals(3, Authors.size());
    //}

    /**
     * Verify successful get by property (equal match)
     */
    //@Test
    //void getByPropertyEqualSuccess() {
        //List<Author> authors = dao.getByPropertyEqual("firstName", "Kathy");
        //assertEquals(1, authors.size());
        //assertEquals(1, authors.get(0).getId());
    //}

    /**
     * Verify successful get by property (like match)
     */
    //@Test
    //void getByPropertyLikeSuccess() {
        //List<Author> authors = dao.getByPropertyLike("lastName", "S");
        //assertEquals(2, authors.size());
    //}


}
