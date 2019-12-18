package dqtravelspots.controller;

import dqtravelspots.entity.Favorite;
import dqtravelspots.entity.Touristspot;
import dqtravelspots.entity.User;
import dqtravelspots.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * A simple servlet to grab some data.
 * @author dqueiser
 */

@WebServlet(
        urlPatterns = {"/searchFaves1"}
)

public class searchFaves1 extends HttpServlet {
    //@Override
    private final Logger logger = LogManager.getLogger(this.getClass());

    GenericDao userDao;
    GenericDao spotDao;

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String currUsername = req.getRemoteUser();
        System.out.println("DQTest87: username is: " + currUsername);
        System.out.println("DQTest87: Creating the userDao");
        userDao = new GenericDao(User.class);
        System.out.println("DQTest87: Getting user list");
        List<User> userList = userDao.findByPropertyEqualQ("userName", currUsername);
        System.out.println("DQTest87: Give me one user");
        User currUser = userList.get(0);
        System.out.println("DQTest87: Getting that user's favorites");
        Set<Favorite> faveList = currUser.getFavorites();
        System.out.println("DQTest87: User has this many faves: " + faveList.size());


        System.out.println("DQTest87: creating the spotDao");
        spotDao = new GenericDao(Touristspot.class);
        System.out.println("DQTest87: getting the t-spots from user");
        List<Touristspot> spotList = new ArrayList<Touristspot>();
        System.out.println("DQTest87: making tmpSpot");
        Touristspot tmpSpot = new Touristspot();

        System.out.println("DQTest87: going to iterate through the set of faves");
        for (Favorite tmpFave : faveList) {
            int spotID = Integer.parseInt(tmpFave.getSpotID());
            System.out.println("DQTest87: spotID = " + spotID);
            tmpSpot = (Touristspot) spotDao.getById(spotID);
            System.out.println("DQTest87: adding the actual spot to the list");
            spotList.add(tmpSpot);
        }

        //String nsPlanetID = String.valueOf(req.getParameter("planet1"));

        //logger.info("DQTESTQ: Planet selected was: " + nsPlanetID);
        //System.out.println("DQTESTQ: Planet selected was: " + nsPlanetID);

        //System.out.println("DQTESTQ: creating the DAO");
        //dao = new GenericDao(Touristspot.class);
        ////List<Touristspot> tSpots = dao.findByPropertyEqualQ("planetID", nsPlanetID);
        //System.out.println("DQTESTQ: submitting a query");
        //List<Touristspot> tSpots = dao.findAllByPropertyLike("planetID", nsPlanetID);
        //System.out.println("DQTESTQ: got some results");
        //int setSize = tSpots.size();
        //System.out.println("Found this many spots: " + setSize);
        req.setAttribute("spotList1", spotList);
        //System.out.println("DQTESTQ: attribute added");
        ////RequestDispatcher dispatcher = req.getRequestDispatcher("/Editspots2.jsp");
        ////System.out.println("DQTESTQ: going to the next webpage");
        ////dispatcher.forward(req, resp);
    }

}