package pl.kkowalewski.controllers;

import org.junit.Before;
import org.junit.Test;
import pl.kkowalewski.services.BasicGreetingService;

import static org.junit.Assert.assertEquals;

public class PropertyInjectedControllerTest {

    /*------------------------ FIELDS REGION ------------------------*/
    private PropertyInjectedController controller;

    /*------------------------ METHODS REGION ------------------------*/
    @Before
    public void setUp() {
        controller = new PropertyInjectedController();
        controller.greetingService = new BasicGreetingService();
    }

    @Test
    public void sayHelloTest() {
        assertEquals(controller.sayHello(), BasicGreetingService.MESSAGE);
    }
}