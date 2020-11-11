package pl.kkowalewski.controllers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import pl.kkowalewski.services.GreetingService;

@Controller
public class ConstructorInjectedController {

    /*------------------------ FIELDS REGION ------------------------*/
    private GreetingService greetingService;

    /*------------------------ METHODS REGION ------------------------*/
    public ConstructorInjectedController(@Qualifier("constructorGreetingService") GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public GreetingService getGreetingService() {
        return greetingService;
    }

    public String sayHello() {
        return greetingService.sayGreeting();
    }
}
