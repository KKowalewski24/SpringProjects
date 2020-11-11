package pl.kkowalewski.service.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.kkowalewski.model.Speciality;

import static org.junit.jupiter.api.Assertions.*;

class SpecialityMapServiceTest {

    /*------------------------ FIELDS REGION ------------------------*/
    private static final String DESCRIPTION = "abc";
    private static final Long SPECIALITY_ID = 1L;

    private SpecialityMapService specialityMapService = new SpecialityMapService();
    private Speciality speciality;

    /*------------------------ METHODS REGION ------------------------*/
    @BeforeEach
    void setUp() {
        speciality = new Speciality(DESCRIPTION);
        speciality.setId(SPECIALITY_ID);
        specialityMapService.save(speciality);
    }

    @Test
    void findByIdTest() {
        assertEquals(speciality, specialityMapService.findById(SPECIALITY_ID));
    }

    @Test
    void saveTest() {
        assertNotNull(specialityMapService.save(speciality));
    }

    @Test
    void deleteTest() {
        specialityMapService.delete(speciality);
        assertEquals(0, specialityMapService.findAll().size());
        assertNull(specialityMapService.findById(SPECIALITY_ID));
    }

    @Test
    void deleteByIdTest() {
        specialityMapService.deleteById(speciality.getId());
        assertEquals(0, specialityMapService.findAll().size());
        assertNull(specialityMapService.findById(SPECIALITY_ID));
    }

    @Test
    void findAllTest() {
        assertEquals(1, specialityMapService.findAll().size());
        assertTrue(specialityMapService.findAll().contains(speciality));
    }
}
    