package pl.kkowalewski.services;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SetterGreetingServiceTest {

    /*------------------------ FIELDS REGION ------------------------*/
    private SetterGreetingService setterGreetingService =
            new SetterGreetingService();

    /*------------------------ METHODS REGION ------------------------*/
    @Test
    public void sayGreeting() {
        assertEquals(setterGreetingService.sayGreeting(), SetterGreetingService.MESSAGE);
    }
}