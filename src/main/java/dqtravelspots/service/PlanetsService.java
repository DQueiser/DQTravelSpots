package dqtravelspots.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import dqtravelspots.entity.Planet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

//import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlanetsService {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * @return Planet
     * @throws JsonProcessingException
     */
    //public List<Planet> getPlanetInfo() throws JsonProcessingException {
    public Planet getPlanetInfo() throws JsonProcessingException {

        //This module is also sadly not being used; I am going to leave my
        //SYstem.out.prinln stmts in only in case I need to demo one last time.

        System.out.println("DQTest3B: In the method");

        Client client = ClientBuilder.newClient();
        System.out.println("DQTest3B: client has been created");
        WebTarget target =
                client.target("https://swapi.co/api/planets/1");
        System.out.println("DQTest3B: Web target has been created");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        System.out.println("DQTest3B: String response was initialized");
        ObjectMapper mapper = new ObjectMapper();
        System.out.println("DQTest3B: Object mapper created");
        Planet planetOne = mapper.readValue(response, Planet.class);
        System.out.println("DQTest3B: planetone read");

        //Client client = ClientBuilder.newClient();
        //WebTarget target =
                //client.target("https://www.zipcodeapi.com/rest/" + apiKey
                        //+ "/radius." + format + "/"+ zipCode + "/" + radius + "/" + units + "?minimal");

        //specify the type of data to get back and get the response
        //String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        //parse response
        //String[] tokens = response.split("\\t|,|;|\\.|\\?|!|-|:|@|\\[|\\]|\\(|\\)|\\{|\\}|_|\\*|/|\"");

        //grab zipCodes beginning at [i]=7,10,13...and add to list
        //for (int i = 7; i < tokens.length; i += 3) {
            //ZipCodesItem item = new ZipCodesItem();
            //item.setZipCode(tokens[i]);
            //List.add(item);
        //}

        //pass list of zipcode items to get parkinglot information
        //List<ParkingLot> parkingLotInfoList = getParkingLotInfo(list);

        //return list of parkinglot info
        //return parkingLotInfoList;
        return planetOne;
    }

    /**
     * this method returns a list of parkinglots based on zipcodes
     * @return planetOne
     */
    //public List<ParkingLot> getParkingLotInfo(List<ZipCodesItem> list) {

        //List<ParkingLot> parkingInfoList = new ArrayList<>();

        //String zip = "";

        //for (ZipCodesItem zipCode : list) {
            //zip += zipCode.getZipCode() + ",";
        //}

        //try {

            //Client client = ClientBuilder.newClient();
            //WebTarget target =
                    //client.target("http://3.130.227.98:8081/parkinglots/" + zip + "");

            //specify the type of data to get back and get the response
            //String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

            //System.out.println(response);

            //map response into a class with jackson library
            //ObjectMapper mapper = new ObjectMapper();

            //parkingInfoList = mapper.readValue(response, new TypeReference<List<ParkingLot>>() {});


        //} catch (Exception e) {
            //logger.error("Unable to map object");
        //}

        //return parkingInfoList;
    //}

}
