package pl.kkowalewski.restclient;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class RestTemplateExamples {

    /*------------------------ FIELDS REGION ------------------------*/
    public static final String API_ROOT = "https://api.predic8.de:443/shop/";
    public static final String CATEGORIES = "categories/";
    public static final String CUSTOMERS = "customers/";

    private RestTemplate restTemplate;

    /*------------------------ METHODS REGION ------------------------*/

    @Before
    public void setUp() {
        restTemplate = new RestTemplate();
    }

    private void printResult(String result) {
        System.err.println("Response: " + result);
    }

    @Test
    public void getCategories() {
        printResult(restTemplate.getForObject(
                API_ROOT + CATEGORIES, JsonNode.class).toString());
    }

    @Test
    public void getCustomers() {
        printResult(restTemplate.getForObject(
                API_ROOT + CUSTOMERS, JsonNode.class).toString());
    }

    @Test
    public void createCustomer() {
        Map<String, Object> map = new HashMap<>();
        map.put("firstname", "Joe");
        map.put("lastname", "Buck");

        printResult(restTemplate.postForObject(
                API_ROOT + CUSTOMERS, map, JsonNode.class).toString());
    }

    @Test
    public void updateCustomer() {
        Map<String, Object> map = new HashMap<>();
        map.put("firstname", "Micheal");
        map.put("lastname", "Weston");

        JsonNode jsonNode = restTemplate.postForObject(
                API_ROOT + CUSTOMERS, map, JsonNode.class);
        printResult(jsonNode.toString());

        /*-------------------------------*/
        map.put("firstname", "Micheal 2");
        map.put("lastname", "Weston 2");

        String id = jsonNode.get("customer_url").textValue().split("/")[3];
        restTemplate.put(API_ROOT + CUSTOMERS + "/" + id, map);
        printResult(restTemplate.getForObject(
                API_ROOT + CUSTOMERS + "/" + id, JsonNode.class).toString());
    }

    @Test
    public void patchUpdateCustomer() {
        HttpComponentsClientHttpRequestFactory requestFactory =
                new HttpComponentsClientHttpRequestFactory();
        restTemplate = new RestTemplate(requestFactory);

        Map<String, Object> map = new HashMap<>();
        map.put("firstname", "Sam");
        map.put("lastname", "Axe");

        JsonNode jsonNode = restTemplate.postForObject(
                API_ROOT + CUSTOMERS, map, JsonNode.class);
        printResult(jsonNode.toString());

        /*-------------------------------*/
        map.put("firstname", "Sam 2");
        map.put("lastname", "Axe 2");

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<>(map, httpHeaders);

        String id = jsonNode.get("customer_url").textValue().split("/")[3];
        printResult(restTemplate.patchForObject(
                API_ROOT + CUSTOMERS + "/" + id, httpEntity, JsonNode.class).toString());
    }

    @Test(expected = HttpClientErrorException.class)
    public void deleteCustomer() {
        Map<String, Object> map = new HashMap<>();
        map.put("firstname", "Les");
        map.put("lastname", "Claypool");

        JsonNode jsonNode = restTemplate.postForObject(
                API_ROOT + CUSTOMERS, map, JsonNode.class);
        printResult(jsonNode.toString());

        String id = jsonNode.get("customer_url").textValue().split("/")[3];
        restTemplate.delete(API_ROOT + CUSTOMERS + "/" + id);
        printResult(restTemplate.getForObject(
                API_ROOT + CUSTOMERS + "/" + id, JsonNode.class).toString());
    }
}