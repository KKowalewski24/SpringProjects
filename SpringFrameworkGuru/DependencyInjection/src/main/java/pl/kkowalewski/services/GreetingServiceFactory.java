package pl.kkowalewski.services;

import pl.kkowalewski.services.repository.GreetingRepository;

public class GreetingServiceFactory {

    /*------------------------ FIELDS REGION ------------------------*/
    private GreetingRepository greetingRepository;

    /*------------------------ METHODS REGION ------------------------*/
    public GreetingServiceFactory(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    public GreetingService createGreetingService(String lang) {
        switch (lang) {
            case "en": {
                return new PrimaryGreetingService(greetingRepository);
            }
            case "pl": {
                return new PrimaryPolishGreetingService(greetingRepository);
            }
            case "de": {
                return new PrimaryGermanGreetingService(greetingRepository);
            }
            default: {
                return new PrimaryGreetingService(greetingRepository);
            }
        }
    }
}
