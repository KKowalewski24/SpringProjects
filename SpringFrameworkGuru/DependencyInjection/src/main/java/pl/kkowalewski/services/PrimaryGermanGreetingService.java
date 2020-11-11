package pl.kkowalewski.services;

import pl.kkowalewski.services.repository.GreetingRepository;

public class PrimaryGermanGreetingService implements GreetingService {

    /*------------------------ FIELDS REGION ------------------------*/
    private GreetingRepository greetingRepository;

    /*------------------------ METHODS REGION ------------------------*/
    public PrimaryGermanGreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @Override
    public String sayGreeting() {
        return greetingRepository.getGermanGreeting();
    }
}
