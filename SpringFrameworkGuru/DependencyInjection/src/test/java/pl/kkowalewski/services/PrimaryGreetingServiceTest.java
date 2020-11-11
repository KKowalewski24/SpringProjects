package pl.kkowalewski.services;

import org.junit.Test;
import pl.kkowalewski.services.repository.BasicGreetingRepository;
import pl.kkowalewski.services.repository.GreetingRepository;

import static org.junit.Assert.assertEquals;

public class PrimaryGreetingServiceTest {

    /*------------------------ FIELDS REGION ------------------------*/
    private GreetingRepository greetingRepository = new BasicGreetingRepository();
    private GreetingService greetingService =
            new PrimaryGreetingService(greetingRepository);

    /*------------------------ METHODS REGION ------------------------*/
    @Test
    public void sayGreeting() {
        assertEquals(greetingService.sayGreeting(), greetingRepository.getEnglishGreeting());
    }
}