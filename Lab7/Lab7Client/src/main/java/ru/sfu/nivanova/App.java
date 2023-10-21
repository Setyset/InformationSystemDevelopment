package ru.sfu.nivanova;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.net.URI;

public class App {
    private static final String url = "http://localhost:8080/bicycle";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws JsonProcessingException {
        System.out.println(retrieveBicycle(1));
        var bicycles = retrieveAll();
        for (var i : bicycles) { System.out.println(i); }

        var bicycle = new Bicycle();
        bicycle.setManufacturer("Giant");
        bicycle.setModel("Small");
        bicycle.setType("Added via REST API during lab7 tests");
        bicycle.setSize(20);
        bicycle.setPrice(BigDecimal.valueOf(120.91));
        bicycle.setInStock(120);


        System.out.println(create(bicycle));
        System.out.println("Trying to delete bicycle 38");
        deleteBicycle(38);
        System.out.println("Trying to delete bicycle 4");
        deleteBicycle(4);

        System.out.println(updateBicycle(5, 60, BigDecimal.valueOf(14.88)));
    }

    public static Bicycle retrieveBicycle(int id) {
        return new RestTemplate().getForObject(
                url + "/{id}",
                Bicycle.class, id);
    }

    public static Bicycle[] retrieveAll() {
        return new RestTemplate().getForObject(url + '/', Bicycle[].class);
    }

    public static void deleteBicycle(int id) {
        new RestTemplate().delete(url + "/{id}", id);
    }

    public static Bicycle updateBicycle(Integer id, int newInStock, BigDecimal newPrice) {
        Bicycle bicycle = new Bicycle();
        bicycle.setPrice(newPrice);
        bicycle.setInStock(newInStock);

        return new RestTemplate().postForObject(url + "/{id}", bicycle, Bicycle.class, id);
    }

    public static Integer create(Bicycle bicycle) throws JsonProcessingException {
        var restTemplate = new RestTemplate();
        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        var bicycleJsonObject = new JSONObject();
        bicycleJsonObject = new JSONObject(bicycle);

        HttpEntity<String> request =
                new HttpEntity<String>(bicycleJsonObject.toString(), headers);

        return restTemplate.postForObject(url + "/", request, Integer.class);
    }
}
