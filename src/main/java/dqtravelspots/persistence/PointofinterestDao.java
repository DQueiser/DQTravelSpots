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

public class PointofinterestDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Get Pointofinterest by id
     */
    public Pointofinterest getById(int id) {
        logger.info("Getting a Pointofinterest by ID");
        Session session = sessionFactory.openSession();
        Pointofinterest pointOfInterest = session.get( Pointofinterest.class, id );
        session.close();
        return pointOfInterest;
    }

    /**
     * update Pointofinterest
     * @param pointOfInterest  Pointofinterest to be inserted or updated
     */
    public void saveOrUpdate(Pointofinterest pointOfInterest) {
        logger.info("Updating a pointofinterest");
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(pointOfInterest);
        transaction.commit();
        session.close();
    }

    /**
     * insert Pointofinterest
     * @param pointOfInterest  Pointofinterest to be inserted
     */
    public int insert(Pointofinterest pointOfInterest) {
        logger.info("Inserting a new pointofinterest");
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(pointOfInterest);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Delete a Pointofinterest
     * @param pointOfInterest Pointofinterest to be deleted
     */
    public void delete(Pointofinterest pointOfInterest) {
        logger.info("Deleting a pointofinterest");
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(pointOfInterest);
        transaction.commit();
        session.close();
    }

    /** Return a list of all Pointofinterests
     *
     * @return All Pointofinterests
     */
    public List<Pointofinterest> getAll() {

        logger.info("Returning a list of Pointofinterests");
        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Pointofinterest> query = builder.createQuery( Pointofinterest.class );
        Root<Pointofinterest> root = query.from( Pointofinterest.class );
        List<Pointofinterest> pointOfInterests = session.createQuery( query ).getResultList();

        logger.debug("The list of Pointofinterests " + pointOfInterests);
        session.close();

        return pointOfInterests;
    }

    /**
     * Get pointofinterest by property (exact match)
     * sample usage: getByPropertyEqual("harrumph", "voter")
     */
    public List<Pointofinterest> getByPropertyEqual(String propertyName, String value) {
        logger.debug("Searching for pointofinterest with " + propertyName + " = " + value);
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Pointofinterest> query = builder.createQuery( Pointofinterest.class );
        Root<Pointofinterest> root = query.from( Pointofinterest.class );
        query.select(root).where(builder.equal(root.get(propertyName), value));
        List<Pointofinterest> pointOfInterests = session.createQuery( query ).getResultList();
        session.close();
        return pointOfInterests;
    }

    /**
     * Get pointofinterest by property (like)
     * sample usage: getByPropertyLike("last_name", "S")
     */
    public List<Pointofinterest> getByPropertyLike(String propertyName, String value) {

        logger.debug("Searching for pointofinterest(s) with {} = {}",  propertyName, value);
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Pointofinterest> query = builder.createQuery( Pointofinterest.class );
        Root<Pointofinterest> root = query.from( Pointofinterest.class );
        Expression<String> propertyPath = root.get(propertyName);

        query.where(builder.like(propertyPath, "%" + value + "%"));
        List<Pointofinterest> pointOfInterests = session.createQuery( query ).getResultList();
        session.close();
        return pointOfInterests;
    }

}
