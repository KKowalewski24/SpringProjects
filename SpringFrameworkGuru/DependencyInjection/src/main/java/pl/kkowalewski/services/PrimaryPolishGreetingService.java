package pl.kkowalewski.services;

import pl.kkowalewski.services.repository.GreetingRepository;

public class PrimaryPolishGreetingService implements GreetingService {

    /*------------------------ FIELDS REGION ------------------------*/
    private GreetingRepository greetingRepository;

    /*------------------------ METHODS REGION ------------------------*/
    public PrimaryPolishGreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @Override
    public String sayGreeting() {
        return greetingRepository.getPolishGreeting();
    }
}
