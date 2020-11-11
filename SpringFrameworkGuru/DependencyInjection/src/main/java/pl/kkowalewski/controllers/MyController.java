package pl.kkowalewski.controllers;

import org.springframework.stereotype.Controller;
import pl.kkowalewski.services.GreetingService;

@Controller
public class MyController {

    /*------------------------ FIELDS REGION ------------------------*/
    private GreetingService greetingService;

    /*------------------------ METHODS REGION ------------------------*/
    public MyController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String sayHello() {
        final String description = "Hello";

        return greetingService.sayGreeting();
    }
}
