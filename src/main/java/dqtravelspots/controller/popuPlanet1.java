package dqtravelspots.controller;

import dqtravelspots.entity.Planet;
import dqtravelspots.persistence.GenericDao;
import dqtravelspots.service.PlanetsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

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
        urlPatterns = {"/popuPlanet1"}
)

public class popuPlanet1 extends HttpServlet {
    //@Override
    private final Logger logger = LogManager.getLogger(this.getClass());

    GenericDao dao;

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String,String> planetMap = new HashMap<String, String>();
        Boolean isValid = true;

        logger.info("DQTEST7: I'm going to fill up my map");
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

        req.setAttribute("planetMap", planetMap);
    }

}