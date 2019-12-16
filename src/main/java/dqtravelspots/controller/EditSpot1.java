package dqtravelspots.controller;

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
import java.util.HashMap;
import java.util.Map;

/**
 * A simple servlet to fill a <list>.
 * @author dqueiser
 */

@WebServlet(
        urlPatterns = {"/editSpot1"}
)

public class EditSpot1 extends HttpServlet {
    //@Override
    private final Logger logger = LogManager.getLogger(this.getClass());

    GenericDao dao;

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String,String> planetMap = new HashMap<String, String>();
        Boolean isValid = true;

        logger.info("DQTEST9: I'm going to fill up my map");
        System.out.println("DQTEST7:I'm going to fill up my map");
        planetMap.put("1","Tatooine");
        planetMap.put("2","Alderaan");
        planetMap.put("3","Yavin IV");
        planetMap.put("4","Hoth");
        planetMap.put("5","Dagobah");
        planetMap.put("6","Bespin");
        planetMap.put("7","Endor");
        planetMap.put("8","Naboo");
        planetMap.put("9","Coruscant");
        planetMap.put("10","Kamino");
        planetMap.put("11","Geonosis");
        planetMap.put("12","Utapau");
        planetMap.put("13","Mustafar");
        planetMap.put("14","Kashyyk");
        planetMap.put("15","Corellia");
        planetMap.put("16","Lah'mu");
        planetMap.put("17","Jedha");
        planetMap.put("18","Eadu");
        planetMap.put("19","Scarif");


        logger.info("DQTEST7: OK, now I'm going to add a spot");
        System.out.println("DQTEST7: OK, now I'm going to add a spot");

        //String firstName = req.getParameter("nu_firstname");
        //String lastName = req.getParameter("nu_lastname");
        //String userName = req.getParameter("nu_username");
        //String emailAddress = req.getParameter("nu_email");
        //String passwordOne = req.getParameter("nu_pass1");
        //String passwordTwo = req.getParameter("nu_pass2");

        //System.out.println("First Name = " + firstName);
        //System.out.println("Last Name = " + lastName);
        //System.out.println("User Name = " + userName);
        //System.out.println("Email = " + emailAddress);
        //System.out.println("Password 1 = " + passwordOne);
        //System.out.println("Password 2 = " + passwordTwo);

        //if (isValid ==  true) {
            //Date today = new Date();
            //dao = new GenericDao(User.class);
            //User newUser = new User(firstName, lastName, emailAddress, userName, passwordOne, today);
            //int id = dao.insert(newUser);
            //dao2 = new GenericDao(Role.class);
            //Role newRole = new Role("User",userName,id);
            //int id2 = dao2.insert(newRole);
            req.setAttribute("planetMap", planetMap);
            //RequestDispatcher dispatcher = req.getRequestDispatcher("/Addspot1.jsp");
            //dispatcher.forward(req, resp);
        //} //else {
            //RequestDispatcher dispatcher = req.getRequestDispatcher("/newuser.jsp");
            //dispatcher.forward(req, resp);
        //}
    }

}