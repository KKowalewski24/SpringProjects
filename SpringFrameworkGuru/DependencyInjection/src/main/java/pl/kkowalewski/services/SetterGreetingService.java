package pl.kkowalewski.services;

import org.springframework.stereotype.Service;

@Service
public class SetterGreetingService implements GreetingService {

    /*------------------------ FIELDS REGION ------------------------*/
    public static final String MESSAGE = "Injected via Setter";

    /*------------------------ METHODS REGION ------------------------*/
    @Override
    public String sayGreeting() {
        return MESSAGE;
    }
}
