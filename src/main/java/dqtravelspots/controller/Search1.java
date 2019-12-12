package dqtravelspots.controller;

import dqtravelspots.entity.Planet;
import org.testng.annotations.Test;
import dqtravelspots.service.PlanetsService;

import dqtravelspots.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * A simple servlet to conduct a POI search.
 * @author dqueiser
 */

@WebServlet(
        urlPatterns = {"/searchPOI"}
)

public class Search1 extends HttpServlet {
    //@Override
    private final Logger logger = LogManager.getLogger(this.getClass());

    GenericDao dao;
    GenericDao dao2;

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Boolean isValid = true;

        logger.info("DQTEST3: I'm going to do a search");
        System.out.println("DQTEST3:I'm going to do a search");

        try {
            testAPIConn();
        } catch (Exception e) {
            e.printStackTrace();
        }

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

        if (isValid ==  true) {
            //Date today = new Date();
            //dao = new GenericDao(User.class);
            //User newUser = new User(firstName, lastName, emailAddress, userName, passwordOne, today);
            //int id = dao.insert(newUser);
            //dao2 = new GenericDao(Role.class);
            //Role newRole = new Role("User",userName,id);
            //int id2 = dao2.insert(newRole);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
            dispatcher.forward(req, resp);
        } //else {
            //RequestDispatcher dispatcher = req.getRequestDispatcher("/newuser.jsp");
            //dispatcher.forward(req, resp);
        //}
    }
    @Test
    public void testAPIConn() throws Exception {
        System.out.println("DQTest3: Setting up the PlanetService");
        PlanetsService newService = new PlanetsService();
        System.out.println("DQTest3: Calling method to get planet info");
        Planet thisPlanet = newService.getPlanetInfo();
        System.out.println("DQTest3: Planet returned is " + thisPlanet.getName());



        //System.out.println("DQTest3: Getting a planet");
        //Client client = ClientBuilder.newClient();
        //WebTarget target =
                //client.target("https://swapi.co/api/planets/1");
        //String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        //ObjectMapper mapper = new ObjectMapper();
        //Planet planet = mapper.readValue(response, Planet.class);
        //System.out.println("DQTest3: Planet returned is " + planet.getName());
    }

}