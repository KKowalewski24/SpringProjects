package pl.kkowalewski.service.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.kkowalewski.model.Speciality;
import pl.kkowalewski.model.Vet;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VetMapServiceTest {

    /*------------------------ FIELDS REGION ------------------------*/
    private VetMapService serviceMap;
    private Vet vetOne;
    private Vet vetTwo;

    /*------------------------ METHODS REGION ------------------------*/
    @BeforeEach
    public void setUp() {
        serviceMap = new VetMapService();
    }

    private boolean prepareMap() {
        Set<Speciality> specialitiesOne = new HashSet<Speciality>();
        specialitiesOne.add(new Speciality("zzz"));
        Set<Speciality> specialitiesTwo = new HashSet<Speciality>();
        specialitiesTwo.add(new Speciality("yyy"));

        vetOne = new Vet("aaa", "bbb", specialitiesOne);
        vetTwo = new Vet("ccc", "ddd", specialitiesTwo);

        if (serviceMap.save(vetOne).equals(vetOne)
                && serviceMap.save(vetTwo).equals(vetTwo)) {
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
        assertEquals(serviceMap.findById(1L), vetOne);
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
        serviceMap.delete(vetTwo);
        assertEquals(serviceMap.findAll().size(), 1);
    }
}