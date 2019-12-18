package dqtravelspots.controller;

import dqtravelspots.entity.Touristspot;
import dqtravelspots.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
        urlPatterns = {"/getSpotDetails"}
)

public class GetSpotDetails extends HttpServlet {
    //@Override
    private final Logger logger = LogManager.getLogger(this.getClass());

    GenericDao dao;

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int placeID = Integer.parseInt(req.getParameter("place"));

        logger.info("DQTESTY: Place selected was: " + placeID);

        dao = new GenericDao(Touristspot.class);

        Touristspot oneSpot = (Touristspot) dao.getById(placeID);

        req.setAttribute("oneSpot", oneSpot);
    }

}