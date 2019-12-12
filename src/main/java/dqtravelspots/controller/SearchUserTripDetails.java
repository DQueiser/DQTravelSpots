package dqtravelspots.controller;

import dqtravelspots.entity.Pointofinterest;
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
 * A simple servlet to search for usertrip details.
 * @author dqueiser
 */

@WebServlet(
        urlPatterns = {"/searchUserTripDetails"}
)

public class SearchUserTripDetails extends HttpServlet {
    //@Override
    private final Logger logger = LogManager.getLogger(this.getClass());
    GenericDao tripDao = new GenericDao(Pointofinterest.class);

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int tripID = Integer.parseInt(req.getParameter("trip"));
        System.out.println("DQTEST6A: The trip passed to me is" + tripID);
        //String searchType = req.getParameter("srchType");
        //logger.info("The search term is " + searchTerm);
        //logger.info("The search type is " + searchType);

        System.out.println("DQTEST6A: In the new SearchUserTripDetails servlet, DAO is ready");
        logger.debug("DQTEST6A: In the new SearchUserTripDetails servlet, DAO is ready");
        //System.out.println("DQTEST4B: Searching for some usertrips and passing to req");
        //logger.debug("DQTEST4B: Searching for some usertrips and passing to req");
        List<Pointofinterest> tripPOIs = tripDao.findByPropertyEqual("usertrips",tripID);
        System.out.println("DQTEST6C: I found this many trip POIs:" + tripPOIs.size());
        req.setAttribute("POIs", tripPOIs);
        System.out.println("DQTEST6D: tripPOIs has been added to req");

        //if (searchType.equals("emp_id")) {
            //req.setAttribute("users", userData.getUsersByID(searchTerm));
        //} else if (searchType.equals("last_name")) {
            //req.setAttribute("users", userData.getUsersByLast(searchTerm));
        //} else if (searchType.equals("first_name")) {
            //req.setAttribute("users", userData.getUsersByFirst(searchTerm));
        //} else if (searchType.equals("all")) {
            //req.setAttribute("users", userData.getAllUsers(searchTerm));
        //}

        RequestDispatcher dispatcher = req.getRequestDispatcher("/UserTripDetail.jsp");
        dispatcher.forward(req, resp);
    }
}