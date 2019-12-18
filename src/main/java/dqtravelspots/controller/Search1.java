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

        //This module is no longer used, other than a test bed
        //To that end, I am leaving the System.out.printlns in, in case I need to demo this.

        Boolean isValid = true;

        logger.info("DQTEST3: I'm going to do a search");

        try {
            testAPIConn();
        } catch (Exception e) {
            e.printStackTrace();
        }


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

    }

}