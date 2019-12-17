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
import java.util.Date;

/**
 * A simple servlet to update some data.
 * @author dqueiser
 */

@WebServlet(
        urlPatterns = {"/updateSpotDetails"}
)

public class UpdateSpotDetails extends HttpServlet {
    //@Override
    private final Logger logger = LogManager.getLogger(this.getClass());

    GenericDao dao;

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int newPlace = Integer.parseInt(req.getParameter("ns_id"));
        String newPlanet = req.getParameter("ns_planetid");
        String newName = req.getParameter("ns_name");
        String newDesc =  req.getParameter("ns_description");

        System.out.println("JKJ: The PLace ID is: " + newPlace);
        System.out.println("JKJ: The planet ID is: " + newPlanet);
        System.out.println("JKJ: The new Name is: " + newName);
        System.out.println("JKJ: The new Desc is: " + newDesc);
        String tmpHandicap = String.valueOf(req.getParameter("ns_handicap"));
        String handicapTrue = "HY";
        String newHandicap = "";
        if (tmpHandicap.equals(handicapTrue)) {
            newHandicap = "True";
        } else {
            newHandicap = "False";
        }
        System.out.println("JKJ: The new Handicap is: " + newHandicap);

        String tmpImperial = String.valueOf(req.getParameter("ns_imperial"));
        String imperialTrue = "IY";
        String newImperial = "";
        if (tmpImperial.equals(imperialTrue)) {
            newImperial = "True";
        } else {
            newImperial = "False";
        }
        System.out.println("JKJ: The new Imperial is: " + newImperial);

        Date today = new Date();
        dao = new GenericDao(Touristspot.class);
        Touristspot spotToUpdate = (Touristspot) dao.getById(newPlace);
        spotToUpdate.setName(newName);
        spotToUpdate.setDescription(newDesc);
        spotToUpdate.setHandicapAccess(newHandicap);
        spotToUpdate.setImperialOnly(newImperial);
        dao.saveOrUpdate(spotToUpdate);
        //System.out.println("JKJHH: Trying to pass parm and it is: " + newPlanet);
        //req.setAttribute("planet1", newPlanet);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/Editspot1.jsp");
        dispatcher.forward(req, resp);

    }

}