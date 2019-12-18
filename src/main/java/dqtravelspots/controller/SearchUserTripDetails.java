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

        logger.debug("DQTEST6A: In the new SearchUserTripDetails servlet, DAO is ready");
        List<Pointofinterest> tripPOIs = tripDao.findByPropertyEqual("usertrips",tripID);
        req.setAttribute("POIs", tripPOIs);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/UserTripDetail.jsp");
        dispatcher.forward(req, resp);
    }
}