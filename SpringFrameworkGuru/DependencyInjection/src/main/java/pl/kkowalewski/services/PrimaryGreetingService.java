package pl.kkowalewski.services;

import pl.kkowalewski.services.repository.GreetingRepository;

public class PrimaryGreetingService implements GreetingService {

    /*------------------------ FIELDS REGION ------------------------*/
    private GreetingRepository greetingRepository;

    /*------------------------ METHODS REGION ------------------------*/
    public PrimaryGreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @Override
    public String sayGreeting() {
        return greetingRepository.getEnglishGreeting();
    }
}
