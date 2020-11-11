package pl.kkowalewski.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import pl.kkowalewski.services.GreetingService;

@Controller
public class SetterInjectedController {

    /*------------------------ FIELDS REGION ------------------------*/
    private GreetingService greetingService;

    /*------------------------ METHODS REGION ------------------------*/
    public GreetingService getGreetingService() {
        return greetingService;
    }

    @Autowired
    public void setGreetingService(@Qualifier("setterGreetingService") GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String sayHello() {
        return greetingService.sayGreeting();
    }
}
