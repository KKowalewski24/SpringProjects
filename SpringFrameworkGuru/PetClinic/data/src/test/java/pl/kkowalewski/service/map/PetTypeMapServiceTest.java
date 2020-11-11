package pl.kkowalewski.service.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.kkowalewski.model.PetType;

import static org.junit.jupiter.api.Assertions.*;

class PetTypeMapServiceTest {

    /*------------------------ FIELDS REGION ------------------------*/
    private static final String TYPE = "abc";
    private static final Long PET_TYPE_ID = 1L;

    private PetTypeMapService petTypeMapService = new PetTypeMapService();
    private PetType petType;

    /*------------------------ METHODS REGION ------------------------*/
    @BeforeEach
    void setUp() {
        petType = new PetType(TYPE);
        petType.setId(PET_TYPE_ID);
        petTypeMapService.save(petType);
    }

    @Test
    void findByIdTest() {
        assertEquals(petType, petTypeMapService.findById(PET_TYPE_ID));
    }

    @Test
    void saveTest() {
        assertNotNull(petTypeMapService.save(petType));
    }

    @Test
    void deleteTest() {
        petTypeMapService.delete(petType);
        assertEquals(0, petTypeMapService.findAll().size());
        assertNull(petTypeMapService.findById(PET_TYPE_ID));
    }

    @Test
    void deleteByIdTest() {
        petTypeMapService.deleteById(petType.getId());
        assertEquals(0, petTypeMapService.findAll().size());
        assertNull(petTypeMapService.findById(PET_TYPE_ID));
    }

    @Test
    void findAllTest() {
        assertEquals(1, petTypeMapService.findAll().size());
        assertTrue(petTypeMapService.findAll().contains(petType));
    }
}
    