package dqtravelspots.controller;

import dqtravelspots.entity.Touristspot;
import dqtravelspots.entity.User;
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
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * A simple servlet to pass some data.
 * @author dqueiser
 */

@WebServlet(
        urlPatterns = {"/addSpot2"}
)

public class AddSpot2 extends HttpServlet {
    //@Override
    private final Logger logger = LogManager.getLogger(this.getClass());

    GenericDao dao;

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nsPlanetID = req.getParameter("planet1");
        String nsName = req.getParameter("ns_name");
        String nsDesc =  req.getParameter("ns_description");

        String tmpHandicap = String.valueOf(req.getParameter("ns_handicap"));
        String handicapTrue = "HY";
        String nsHandicap = "";
        if (tmpHandicap.equals(handicapTrue)) {
            nsHandicap = "True";
        } else {
            nsHandicap = "False";
        }

        String tmpImperial = String.valueOf(req.getParameter("ns_imperial"));
        String imperialTrue = "IY";
        String nsImperial = "";
        if (tmpImperial.equals(imperialTrue)) {
            nsImperial = "True";
        } else {
            nsImperial = "False";
        }

        logger.info("DQTEST8: Planet selected was: " + nsPlanetID);

        Date today = new Date();
        dao = new GenericDao(Touristspot.class);
        Touristspot newSpot = new Touristspot(nsPlanetID, nsName, nsDesc, nsHandicap, nsImperial, today);
        int id = dao.insert(newSpot);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, resp);
    }

}