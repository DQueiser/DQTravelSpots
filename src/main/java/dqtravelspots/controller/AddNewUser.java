package dqtravelspots.controller;

import dqtravelspots.entity.User;
import dqtravelspots.entity.Usertrip;
import dqtravelspots.persistence.UsertripDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.swing.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * A simple servlet to add a new user.
 * @author dqueiser
 */

@WebServlet(
        urlPatterns = {"/addNewUser"}
)

public class AddNewUser extends HttpServlet {
    //@Override
    private final Logger logger = LogManager.getLogger(this.getClass());
    //UsertripDao dao = new UsertripDao();

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //String searchTerm = req.getParameter("srchTerm");
        //String searchType = req.getParameter("srchType");
        //logger.info("The search term is " + searchTerm);
        //logger.info("The search type is " + searchType);

        Boolean isValid = true;

        logger.info("DQTEST2: Prepping to add a new user");
        System.out.println("DQTEST2:Prepping to add a new user");

        String firstName = req.getParameter("nu_firstname");
        String lastName = req.getParameter("nu_lastname");
        String userName = req.getParameter("nu_username");
        String emailAddress = req.getParameter("nu_email");
        String passwordOne = req.getParameter("nu_pass1");
        String passwordTwo = req.getParameter("nu_pass2");

        System.out.println("First Name = " + firstName);
        System.out.println("Last Name = " + lastName);
        System.out.println("User Name = " + userName);
        System.out.println("Email = " + emailAddress);
        System.out.println("Password 1 = " + passwordOne);
        System.out.println("Password 2 = " + passwordTwo);

        if (userName == "") {
            JFrame parent = new JFrame();
            JOptionPane.showMessageDialog(parent,"You need to enter a User Name");
            isValid = false;
        }
        //logger.debug("DQTEST2: DAO is set; ");
        //List<Usertrip> userTrips = dao.getByPropertyEqual("cityLocation", "ACIDPLANIT");
        //List<Usertrip> userTrips = dao.getByUserID(2);
        //logger.debug("DQTEST2: Searching for some usertrips and passing to req");
        //req.setAttribute("userTrips", userTrips);

        //if (searchType.equals("emp_id")) {
            //req.setAttribute("users", userData.getUsersByID(searchTerm));
        //} else if (searchType.equals("last_name")) {
            //req.setAttribute("users", userData.getUsersByLast(searchTerm));
        //} else if (searchType.equals("first_name")) {
            //req.setAttribute("users", userData.getUsersByFirst(searchTerm));
        //} else if (searchType.equals("all")) {
            //req.setAttribute("users", userData.getAllUsers(searchTerm));
        //}

        if (isValid ==  true) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/login.jsp");
            dispatcher.forward(req, resp);
        } else {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/newuser.jsp");
            dispatcher.forward(req, resp);
        }
    }
}