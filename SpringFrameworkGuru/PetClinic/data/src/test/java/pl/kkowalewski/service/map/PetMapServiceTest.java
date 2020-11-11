package pl.kkowalewski.service.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.kkowalewski.model.Owner;
import pl.kkowalewski.model.Pet;
import pl.kkowalewski.model.PetType;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PetMapServiceTest {

    /*------------------------ FIELDS REGION ------------------------*/
    private PetMapService serviceMap;
    private Pet petOne;
    private Pet petTwo;

    /*------------------------ METHODS REGION ------------------------*/
    @BeforeEach
    public void setUp() {
        serviceMap = new PetMapService();
    }

    private boolean prepareMap() {
        LocalDate today = LocalDate.now();
        petOne = new Pet("petOne", new PetType("A"),
                new Owner("abc", "cde", "qqq", "waw", "123"), today);
        petTwo = new Pet("petTwo", new PetType("B"),
                new Owner("eee", "fff", "www", "lodz", "456"), today);

        if (serviceMap.save(petOne).equals(petOne)
                && serviceMap.save(petTwo).equals(petTwo)) {
            return true;
        }

        return false;
    }

    @Test
    public void findAllTest() {
        assertEquals(serviceMap.findAll().size(), 0);
    }

    @Test
    public void saveTest() {
        assertTrue(prepareMap());
        assertEquals(serviceMap.findAll().size(), 2);
    }

    @Test
    public void findByIdTest() {
        assertTrue(prepareMap());
        assertEquals(serviceMap.findById(1L), petOne);
    }

    @Test
    public void deleteByIdTest() {
        assertTrue(prepareMap());
        serviceMap.deleteById(1L);
        assertEquals(serviceMap.findAll().size(), 1);
    }

    @Test
    public void deleteTest() {
        assertTrue(prepareMap());
        serviceMap.delete(petTwo);
        assertEquals(serviceMap.findAll().size(), 1);
    }
}