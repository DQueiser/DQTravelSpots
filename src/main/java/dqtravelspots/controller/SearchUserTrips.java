package dqtravelspots.controller;

import dqtravelspots.entity.Pointofinterest;
import dqtravelspots.entity.User;
import dqtravelspots.entity.Usertrip;
import dqtravelspots.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * A simple servlet to search for usertrips.
 * @author dqueiser
 */

@WebServlet(
        urlPatterns = {"/searchUserTrips"}
)

public class SearchUserTrips extends HttpServlet {
    //@Override
    private final Logger logger = LogManager.getLogger(this.getClass());
    GenericDao tripDao = new GenericDao(Usertrip.class);

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //String searchTerm = req.getParameter("srchTerm");
        //String searchType = req.getParameter("srchType");
        //logger.info("The search term is " + searchTerm);
        //logger.info("The search type is " + searchType);

        System.out.println("DQTEST4A: In the SearchUserTrip servlet, DAO is ready");
        logger.debug("DQTEST4A: : In the SearchUserTrip servlet, DAO is ready");
        //List<Usertrip> userTrips = dao.getByPropertyEqual("cityLocation", "ACIDPLANIT");
        System.out.println("DQTEST4B: Searching for some usertrips and passing to req");
        logger.debug("DQTEST4B: Searching for some usertrips and passing to req");
        List<Usertrip> userTrips = tripDao.findByPropertyEqual("user",2);
        System.out.println("DQTEST4C: I found this many trips:" + userTrips.size());
        req.setAttribute("userTrips", userTrips);
        System.out.println("DQTEST4D: userTrips has been added to req");

        //if (searchType.equals("emp_id")) {
            //req.setAttribute("users", userData.getUsersByID(searchTerm));
        //} else if (searchType.equals("last_name")) {
            //req.setAttribute("users", userData.getUsersByLast(searchTerm));
        //} else if (searchType.equals("first_name")) {
            //req.setAttribute("users", userData.getUsersByFirst(searchTerm));
        //} else if (searchType.equals("all")) {
            //req.setAttribute("users", userData.getAllUsers(searchTerm));
        //}

        RequestDispatcher dispatcher = req.getRequestDispatcher("/UserTrip.jsp");
        dispatcher.forward(req, resp);
    }
}