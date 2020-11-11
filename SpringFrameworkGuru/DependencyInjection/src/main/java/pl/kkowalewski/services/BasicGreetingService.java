package pl.kkowalewski.services;

import org.springframework.stereotype.Service;

@Service
public class BasicGreetingService implements GreetingService {

    /*------------------------ FIELDS REGION ------------------------*/
    public static final String MESSAGE = "Greeting Service";

    /*------------------------ METHODS REGION ------------------------*/
    @Override
    public String sayGreeting() {
        return MESSAGE;
    }
}
