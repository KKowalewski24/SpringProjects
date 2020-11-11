package pl.kkowalewski.services;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConstructorGreetingServiceTest {

    /*------------------------ FIELDS REGION ------------------------*/
    private ConstructorGreetingService constructorGreetingService =
            new ConstructorGreetingService();

    /*------------------------ METHODS REGION ------------------------*/
    @Test
    public void sayGreeting() {
        assertEquals(constructorGreetingService.sayGreeting(), ConstructorGreetingService.MESSAGE);
    }
}