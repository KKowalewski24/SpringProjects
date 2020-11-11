package pl.kkowalewski.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    /*------------------------ FIELDS REGION ------------------------*/
    private Person person;
    private Person personSecond;

    /*------------------------ METHODS REGION ------------------------*/
    @BeforeEach
    public void setUp() {
        person = new Person("abc", "cde");
        personSecond = new Person("abc", "cde");
    }

    @Test
    public void equalsTest() {
        assertTrue(person.equals(personSecond)
                && personSecond.equals(person));
    }

    @Test
    public void hashCodeTest() {
        assertEquals(person.hashCode(), personSecond.hashCode());
    }

    @Test
    public void toStringTest() {
        assertNotNull(person.toString());
    }
}