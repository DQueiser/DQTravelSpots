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
import java.util.Date;
import java.util.List;

/**
 * A simple servlet to grab some data.
 * @author dqueiser
 */

@WebServlet(
        urlPatterns = {"/searchSpotsAdd1"}
)

public class searchSpotsAdd1 extends HttpServlet {
    //@Override
    private final Logger logger = LogManager.getLogger(this.getClass());

    GenericDao userDao;
    GenericDao faveDao;

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String currUser = req.getRemoteUser();
        String placeID = String.valueOf(req.getParameter("place"));

        userDao = new GenericDao(User.class);
        faveDao = new GenericDao(Favorite.class);
        List<User> userList = userDao.findByPropertyEqualQ("userName", currUser);
        User userToUpdate = userList.get(0);

        Date today = new Date();

        Favorite newFavorite = new Favorite(userToUpdate, placeID, today);
        userToUpdate.addFavorite(newFavorite);
        int id = faveDao.insert(newFavorite);
    }

}