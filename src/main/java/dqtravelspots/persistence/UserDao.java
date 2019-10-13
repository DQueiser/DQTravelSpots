package dqtravelspots.persistence;

import dqtravelspots.entity.User;
import dqtravelspots.entity.Usertrip;
import dqtravelspots.entity.Pointofinterest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Get User by id
     */
    public User getById(int id) {
        logger.info("Getting a user by ID");
        Session session = sessionFactory.openSession();
        User user = session.get( User.class, id );
        session.close();
        return User;
    }

    /**
     * update User
     * @param User  User to be inserted or updated
     */
    public void saveOrUpdate(User user) {
        logger.info("Updating a user");
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(user);
        transaction.commit();
        session.close();
    }

    /**
     * insert User
     * @param user  User to be inserted
     */
    public int insert(User user) {
        logger.info("Inserting a new user");
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(user);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Delete an User
     * @param user User to be deleted
     */
    public void delete(User user) {
        logger.info("Deleting a user");
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
        session.close();
    }

    /** Return a list of all Users
     *
     * @return All Users
     */
    public List<User> getAll() {

        logger.info("Returning a list of Users");
        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery( User.class );
        Root<User> root = query.from( User.class );
        List<User> users = session.createQuery( query ).getResultList();

        logger.debug("The list of Users " + users);
        session.close();

        return users;
    }

    /**
     * Get user by property (exact match)
     * sample usage: getByPropertyEqual("harrumph", "voter")
     */
    public List<User> getByPropertyEqual(String propertyName, String value) {
        logger.debug("Searching for user with " + propertyName + " = " + value);
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery( User.class );
        Root<User> root = query.from( User.class );
        query.select(root).where(builder.equal(root.get(propertyName), value));
        List<User> users = session.createQuery( query ).getResultList();
        session.close();
        return users;
    }

    /**
     * Get user by property (like)
     * sample usage: getByPropertyLike("last_name", "S")
     */
    public List<User> getByPropertyLike(String propertyName, String value) {

        logger.debug("Searching for user(s) with {} = {}",  propertyName, value);
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery( User.class );
        Root<User> root = query.from( User.class );
        Expression<String> propertyPath = root.get(propertyName);

        query.where(builder.like(propertyPath, "%" + value + "%"));
        List<User> users = session.createQuery( query ).getResultList();
        session.close();
        return users;
    }

}
