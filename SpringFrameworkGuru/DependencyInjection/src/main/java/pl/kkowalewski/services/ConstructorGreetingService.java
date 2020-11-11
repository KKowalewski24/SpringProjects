package pl.kkowalewski.services;

import org.springframework.stereotype.Service;

@Service
public class ConstructorGreetingService implements GreetingService {

    /*------------------------ FIELDS REGION ------------------------*/
    public static final String MESSAGE = "Injected via Constructor";

    /*------------------------ METHODS REGION ------------------------*/
    @Override
    public String sayGreeting() {
        return MESSAGE;
    }
}
