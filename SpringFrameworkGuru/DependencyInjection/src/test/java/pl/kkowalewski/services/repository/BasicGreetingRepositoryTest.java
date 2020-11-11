package pl.kkowalewski.services.repository;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BasicGreetingRepositoryTest {

    /*------------------------ FIELDS REGION ------------------------*/
    private GreetingRepository greetingRepository;

    /*------------------------ METHODS REGION ------------------------*/
    @Before
    public void setUp() {
        greetingRepository = new BasicGreetingRepository();
    }

    @Test
    public void getEnglishGreeting() {
        assertEquals(greetingRepository.getEnglishGreeting(), BasicGreetingRepository.MESSAGE[0]);
    }

    @Test
    public void getPolishGreeting() {
        assertEquals(greetingRepository.getPolishGreeting(), BasicGreetingRepository.MESSAGE[1]);
    }

    @Test
    public void getGermanGreeting() {
        assertEquals(greetingRepository.getGermanGreeting(), BasicGreetingRepository.MESSAGE[2]);
    }
}