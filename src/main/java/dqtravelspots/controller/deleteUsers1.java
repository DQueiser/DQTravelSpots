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
        System.out.println("DQTest07: User IDis : " + userID);

        System.out.println("DQTest07: Creating the userDao");
        userDao = new GenericDao(User.class);
        System.out.println("DQTest07: Whacking the User");
        //List<User> userList = userDao.getAll();
        userDao.delete(userDao.getById(userID));

        System.out.println("DQTest07: I'm sorry, Jim. He's gone.");

        //req.setAttribute("userList1", userList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/EditUser1.jsp");
        dispatcher.forward(req, resp);
    }

}