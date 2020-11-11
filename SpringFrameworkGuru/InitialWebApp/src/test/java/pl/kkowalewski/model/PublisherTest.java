package pl.kkowalewski.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PublisherTest {

    /*------------------------ FIELDS REGION ------------------------*/
    private Publisher publisher;
    private Publisher publisherSecond;

    /*------------------------ METHODS REGION ------------------------*/
    @Before
    public void setUp() throws Exception {
        publisher = new Publisher();
        publisherSecond = new Publisher();
    }

    @Test
    public void equalsTest() {
        assertTrue(publisher.equals(publisherSecond)
                && publisherSecond.equals(publisher));
    }

    @Test
    public void hashCodeTest() {
        assertEquals(publisher.hashCode(), publisherSecond.hashCode());
    }

    @Test
    public void toStringTest() {
        assertNotNull(publisher.toString());
    }
}