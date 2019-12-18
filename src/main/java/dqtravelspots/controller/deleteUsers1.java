package dqtravelspots.controller;

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
import java.util.List;

/**
 * A simple servlet to whack one User, but good.
 * @author dqueiser
 */

@WebServlet(
        urlPatterns = {"/deleteUsers1"}
)

public class deleteUsers1 extends HttpServlet {
    //@Override
    private final Logger logger = LogManager.getLogger(this.getClass());

    GenericDao userDao;

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int userID = Integer.parseInt(req.getParameter("user"));

        userDao = new GenericDao(User.class);
        userDao.delete(userDao.getById(userID));

        RequestDispatcher dispatcher = req.getRequestDispatcher("/EditUser1.jsp");
        dispatcher.forward(req, resp);
    }

}