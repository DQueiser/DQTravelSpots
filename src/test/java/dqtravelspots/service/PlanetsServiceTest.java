package dqtravelspots.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import dqtravelspots.entity.Planet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlanetsServiceTest {

    @Test
    void getPlanetInfo() throws JsonProcessingException {
        PlanetsService myService = new PlanetsService();
        Planet thisPlanet = myService.getPlanetInfo();
        System.out.println(thisPlanet.getName());

    }
}