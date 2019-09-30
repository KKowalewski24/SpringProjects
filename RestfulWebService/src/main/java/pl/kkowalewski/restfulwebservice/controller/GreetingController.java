package pl.kkowalewski.restfulwebservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.kkowalewski.restfulwebservice.model.Greeting;

import java.util.concurrent.atomic.AtomicLong;

import static pl.kkowalewski.restfulwebservice.constant.AppConstants.PATH_GREETING;

@RestController
public class GreetingController {

    /*------------------------ FIELDS REGION ------------------------*/
    private String message = "Hello, %s!";

    /*------------------------ METHODS REGION ------------------------*/
    @GetMapping(PATH_GREETING)
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(new AtomicLong().incrementAndGet(), String.format(message, name));
    }
}
