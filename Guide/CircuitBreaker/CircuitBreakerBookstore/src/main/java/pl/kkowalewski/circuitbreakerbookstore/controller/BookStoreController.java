package pl.kkowalewski.circuitbreakerbookstore.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookStoreController {

    /*------------------------ FIELDS REGION ------------------------*/
    private String value = "Spring in Action (Manning), Cloud Native Java (O'Reilly)," +
            " Learning Spring Boot (Packt)";

    /*------------------------ METHODS REGION ------------------------*/
    @RequestMapping("/recommended")
    public String readingList() {
        return value;
    }
}
