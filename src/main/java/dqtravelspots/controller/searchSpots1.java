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
        System.out.println("DQTESTQ: Planet selected was: " + nsPlanetID);

        System.out.println("DQTESTQ: creating the DAO");
        dao = new GenericDao(Touristspot.class);
        //List<Touristspot> tSpots = dao.findByPropertyEqualQ("planetID", nsPlanetID);
        System.out.println("DQTESTQ: submitting a query");
        List<Touristspot> tSpots = dao.findAllByPropertyLike("planetID", nsPlanetID);
        System.out.println("DQTESTQ: got some results");
        int setSize = tSpots.size();
        System.out.println("Found this many spots: " + setSize);
        req.setAttribute("tSpots1", tSpots);
        System.out.println("DQTESTQ: attribute added");
        //RequestDispatcher dispatcher = req.getRequestDispatcher("/Editspots2.jsp");
        //System.out.println("DQTESTQ: going to the next webpage");
        //dispatcher.forward(req, resp);
    }

}