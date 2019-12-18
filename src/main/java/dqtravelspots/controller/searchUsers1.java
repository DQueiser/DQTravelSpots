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
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * A simple servlet to grab user data.
 * @author dqueiser
 */

@WebServlet(
        urlPatterns = {"/searchUsers1"}
)

public class searchUsers1 extends HttpServlet {
    //@Override
    private final Logger logger = LogManager.getLogger(this.getClass());

    GenericDao userDao;

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        userDao = new GenericDao(User.class);
        List<User> userList = userDao.getAll();

        req.setAttribute("userList1", userList);
    }

}