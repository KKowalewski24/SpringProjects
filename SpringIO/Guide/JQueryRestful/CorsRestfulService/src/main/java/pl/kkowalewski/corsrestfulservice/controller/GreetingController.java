package pl.kkowalewski.corsrestfulservice.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.kkowalewski.corsrestfulservice.model.Greeting;

@RestController
public class GreetingController {

    /*------------------------ FIELDS REGION ------------------------*/
    private Long counter = 0L;

    /*------------------------ METHODS REGION ------------------------*/
    private Long incrementCounter() {
        this.counter += 1;
        return this.counter;
    }

    @CrossOrigin(origins = "http://localhost:63342")
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(required = false, defaultValue = "") String name) {
        return new Greeting(incrementCounter(), "Hello, " + name);
    }
}
