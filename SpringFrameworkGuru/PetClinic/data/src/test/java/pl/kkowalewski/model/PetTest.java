package pl.kkowalewski.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class PetTest {

    /*------------------------ FIELDS REGION ------------------------*/
    private Pet pet;
    private Pet petSecond;

    /*------------------------ METHODS REGION ------------------------*/
    @BeforeEach
    public void setUp() {
        LocalDate today = LocalDate.now();
        pet = new Pet("petOne", new PetType("A"),
                new Owner("abc", "cde", "qqq", "waw", "123"), today);
        petSecond = new Pet("petOne", new PetType("A"),
                new Owner("abc", "cde", "qqq", "waw", "123"), today);
    }

    @Test
    public void equalsTest() {
        assertTrue(pet.equals(petSecond)
                && petSecond.equals(pet));
    }

    @Test
    public void hashCodeTest() {
        assertEquals(pet.hashCode(), petSecond.hashCode());
    }

    @Test
    public void toStringTest() {
        assertNotNull(pet.toString());
    }
}