package pl.kkowalewski.service.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.kkowalewski.model.Owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OwnerMapServiceTest {

    /*------------------------ FIELDS REGION ------------------------*/
    private OwnerMapService serviceMap;
    private Owner ownerOne;
    private Owner ownerTwo;

    /*------------------------ METHODS REGION ------------------------*/
    @BeforeEach
    public void setUp() {
        serviceMap = new OwnerMapService(new PetTypeMapService(), new PetMapService());
    }

    private boolean prepareMap() {
        ownerOne = new Owner("abc", "cde", "qqq", "waw", "123");
        ownerTwo = new Owner("eee", "fff", "www", "lodz", "456");

        if (serviceMap.save(ownerOne).equals(ownerOne)
                && serviceMap.save(ownerTwo).equals(ownerTwo)) {
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
        assertEquals(serviceMap.findById(1L), ownerOne);
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
        serviceMap.delete(ownerTwo);
        assertEquals(serviceMap.findAll().size(), 1);
    }

    @Test
    void findByLastNameTest() {
        assertTrue(prepareMap());
        assertEquals(ownerOne, serviceMap.findByLastName("cde"));
    }

    @Test
    void findByLastNameNullTest() {
        assertTrue(prepareMap());
        assertEquals(null, serviceMap.findByLastName("avc"));
    }
}