package pl.kkowalewski.services;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BasicGreetingServiceTest {

    /*------------------------ FIELDS REGION ------------------------*/
    private BasicGreetingService basicGreetingService = new BasicGreetingService();

    /*------------------------ METHODS REGION ------------------------*/
    @Test
    public void sayGreeting() {
        assertEquals(basicGreetingService.sayGreeting(), BasicGreetingService.MESSAGE);
    }
}