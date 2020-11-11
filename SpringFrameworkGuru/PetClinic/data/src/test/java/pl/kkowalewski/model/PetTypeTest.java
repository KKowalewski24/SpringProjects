package pl.kkowalewski.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PetTypeTest {

    /*------------------------ FIELDS REGION ------------------------*/
    private PetType petType;
    private PetType petTypeSecond;

    /*------------------------ METHODS REGION ------------------------*/
    @BeforeEach
    public void setUp() {
        petType = new PetType("A");
        petTypeSecond = new PetType("A");
    }

    @Test
    public void equalsTest() {
        assertTrue(petType.equals(petTypeSecond)
                && petTypeSecond.equals(petType));
    }

    @Test
    public void hashCodeTest() {
        assertEquals(petType.hashCode(), petTypeSecond.hashCode());
    }

    @Test
    public void toStringTest() {
        assertNotNull(petType.toString());
    }
}