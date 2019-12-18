package dqtravelspots.controller;

import dqtravelspots.entity.Role;
import dqtravelspots.entity.User;
import dqtravelspots.entity.Usertrip;
import dqtravelspots.persistence.GenericDao;
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
import java.util.Date;
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

    GenericDao dao;
    GenericDao dao2;

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Boolean isValid = true;

        logger.info("DQTEST2: Prepping to add a new user");

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

        if (!passwordOne.equals(passwordTwo)) {
            JFrame parent = new JFrame();
            JOptionPane.showMessageDialog(parent,"The passwords you entered do not match");
            isValid = false;
        }

        if (isValid ==  true) {
            Date today = new Date();
            dao = new GenericDao(User.class);
            User newUser = new User(firstName, lastName, emailAddress, userName, passwordOne, today);
            int id = dao.insert(newUser);
            dao2 = new GenericDao(Role.class);
            Role newRole = new Role("User",userName,id);
            int id2 = dao2.insert(newRole);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/login.jsp");
            dispatcher.forward(req, resp);
        } else {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/newuser.jsp");
            dispatcher.forward(req, resp);
        }
    }
}