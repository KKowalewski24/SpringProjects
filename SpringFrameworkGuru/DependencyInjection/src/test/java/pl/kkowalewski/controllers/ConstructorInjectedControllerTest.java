package pl.kkowalewski.controllers;

import org.junit.Before;
import org.junit.Test;
import pl.kkowalewski.services.BasicGreetingService;

import static org.junit.Assert.assertEquals;

public class ConstructorInjectedControllerTest {

    /*------------------------ FIELDS REGION ------------------------*/
    private ConstructorInjectedController controller;

    /*------------------------ METHODS REGION ------------------------*/
    @Before
    public void setUp() {
        controller = new ConstructorInjectedController(new BasicGreetingService());
    }

    @Test
    public void sayHelloTest() {
        assertEquals(controller.sayHello(), BasicGreetingService.MESSAGE);
    }
}