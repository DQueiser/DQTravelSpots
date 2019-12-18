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

        userDao = new GenericDao(User.class);

        List<User> userList = userDao.findByPropertyEqualQ("userName", currUsername);

        User currUser = userList.get(0);

        Set<Favorite> faveList = currUser.getFavorites();

        spotDao = new GenericDao(Touristspot.class);

        List<Touristspot> spotList = new ArrayList<Touristspot>();

        Touristspot tmpSpot = new Touristspot();

        for (Favorite tmpFave : faveList) {
            int spotID = Integer.parseInt(tmpFave.getSpotID());
            tmpSpot = (Touristspot) spotDao.getById(spotID);
            spotList.add(tmpSpot);
        }
        req.setAttribute("spotList1", spotList);
    }

}