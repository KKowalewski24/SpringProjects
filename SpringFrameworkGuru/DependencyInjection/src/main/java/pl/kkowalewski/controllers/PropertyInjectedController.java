package pl.kkowalewski.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import pl.kkowalewski.services.GreetingService;

@Controller
public class PropertyInjectedController {

    /*------------------------ FIELDS REGION ------------------------*/
    @Autowired
    @Qualifier("basicGreetingService")
    public GreetingService greetingService;

    /*------------------------ METHODS REGION ------------------------*/
    public String sayHello() {
        return greetingService.sayGreeting();
    }
}
