package dqtravelspots.controller;

import dqtravelspots.entity.Touristspot;
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
 * A simple servlet to grab some data.
 * @author dqueiser
 */

@WebServlet(
        urlPatterns = {"/searchSpots1"}
)

public class searchSpots1 extends HttpServlet {
    //@Override
    private final Logger logger = LogManager.getLogger(this.getClass());

    GenericDao dao;

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nsPlanetID = String.valueOf(req.getParameter("planet1"));

        logger.info("DQTESTQ: Planet selected was: " + nsPlanetID);

        dao = new GenericDao(Touristspot.class);

        List<Touristspot> tSpots = dao.findAllByPropertyLike("planetID", nsPlanetID);
        int setSize = tSpots.size();
        req.setAttribute("tSpots1", tSpots);
    }

}