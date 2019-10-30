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

public class UsertripDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Get Usertrip by id
     */
    public Usertrip getById(int id) {
        logger.info("Getting a usertrip by ID");
        Session session = sessionFactory.openSession();
        Usertrip userTrip = session.get( Usertrip.class, id );
        session.close();
        return userTrip;
    }

    /**
     * update Usertrip
     * @param userTrip  Usertrip to be inserted or updated
     */
    public void saveOrUpdate(Usertrip userTrip) {
        logger.info("Updating a usertrip");
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(userTrip);
        transaction.commit();
        session.close();
    }

    /**
     * insert Usertrip
     * @param userTrip  Usertrip to be inserted
     */
    public int insert(Usertrip userTrip) {
        logger.info("Inserting a new usertrip");
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(userTrip);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Delete a Usertrip
     * @param userTrip Usertrip to be deleted
     */
    public void delete(Usertrip userTrip) {
        logger.info("Deleting a usertrip");
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(userTrip);
        transaction.commit();
        session.close();
    }

    /** Return a list of all Usertrips
     *
     * @return All Usertrips
     */
    public List<Usertrip> getAll() {

        logger.info("Returning a list of Usertrips");
        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Usertrip> query = builder.createQuery( Usertrip.class );
        Root<Usertrip> root = query.from( Usertrip.class );
        List<Usertrip> userTrips = session.createQuery( query ).getResultList();

        logger.debug("The list of Usertrips " + userTrips);
        session.close();

        return userTrips;
    }

    /**
     * Get usertrip by property (exact match)
     * sample usage: getByPropertyEqual("harrumph", "voter")
     */
    public List<Usertrip> getByPropertyEqual(String propertyName, String value) {
        logger.debug("Searching for usertrip with " + propertyName + " = " + value);
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Usertrip> query = builder.createQuery( Usertrip.class );
        Root<Usertrip> root = query.from( Usertrip.class );
        query.select(root).where(builder.equal(root.get(propertyName), value));
        List<Usertrip> userTrips = session.createQuery( query ).getResultList();
        session.close();
        return userTrips;
    }

    /**
     * Get usertrip by user_id (exact match)
     * sample usage: getByPropertyEqual("harrumph", "voter")
     */
    public List<Usertrip> getByUserID(int userID) {
        logger.debug("Retrieving all usertrips for user_id: " + userID);
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Usertrip> query = builder.createQuery( Usertrip.class );
        Root<Usertrip> root = query.from( Usertrip.class );
        query.select(root).where(builder.equal(root.get("user"), userID));
        List<Usertrip> userTrips = session.createQuery( query ).getResultList();
        session.close();
        return userTrips;
    }

    /**
     * Get usertrip by property (like)
     * sample usage: getByPropertyLike("last_name", "S")
     */
    public List<Usertrip> getByPropertyLike(String propertyName, String value) {

        logger.debug("Searching for usertrip(s) with {} = {}",  propertyName, value);
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Usertrip> query = builder.createQuery( Usertrip.class );
        Root<Usertrip> root = query.from( Usertrip.class );
        Expression<String> propertyPath = root.get(propertyName);

        query.where(builder.like(propertyPath, "%" + value + "%"));
        List<Usertrip> userTrips = session.createQuery( query ).getResultList();
        session.close();
        return userTrips;
    }

}
