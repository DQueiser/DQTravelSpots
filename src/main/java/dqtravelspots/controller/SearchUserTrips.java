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
    GenericDao userDao = new GenericDao(User.class);
    GenericDao tripDao = new GenericDao(Usertrip.class);

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userName2 = req.getRemoteUser();
        List<User> thisUser = userDao.findByPropertyEqual("userName", userName2);
        User currUser = thisUser.get(0);
        int userID = currUser.getId();

        List<Usertrip> userTrips = tripDao.findByPropertyEqual("user",userID);
        req.setAttribute("userTrips", userTrips);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/UserTrip.jsp");
        dispatcher.forward(req, resp);
    }
}