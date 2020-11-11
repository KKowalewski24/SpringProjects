package pl.kkowalewski.controllers;

import org.junit.Before;
import org.junit.Test;
import pl.kkowalewski.services.BasicGreetingService;

import static org.junit.Assert.assertEquals;

public class MyControllerTest {

    /*------------------------ FIELDS REGION ------------------------*/
    private MyController myController;

    /*------------------------ METHODS REGION ------------------------*/
    @Before
    public void setUp() {
        myController = new MyController(new BasicGreetingService());
    }

    @Test
    public void sayHello() {
        assertEquals(myController.sayHello(), BasicGreetingService.MESSAGE);
    }
}