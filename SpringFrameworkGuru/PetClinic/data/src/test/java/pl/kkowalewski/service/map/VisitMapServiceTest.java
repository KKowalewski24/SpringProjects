package pl.kkowalewski.service.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.kkowalewski.model.Owner;
import pl.kkowalewski.model.Pet;
import pl.kkowalewski.model.PetType;
import pl.kkowalewski.model.Visit;
import pl.kkowalewski.service.exception.ObjectIsNullException;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class VisitMapServiceTest {

    /*------------------------ FIELDS REGION ------------------------*/
    private static final String DESCRIPTION = "abc";
    private static final Long VISIT_ID = 1L;
    private static final LocalDate today = LocalDate.now();

    private VisitMapService visitMapService = new VisitMapService();
    private Visit visit;

    /*------------------------ METHODS REGION ------------------------*/
    @BeforeEach
    void setUp() {
        visit = new Visit(today, DESCRIPTION,
                new Pet("petOne", new PetType("A"),
                        new Owner("abc", "cde", "qqq", "waw", "123"), today));
        visit.setId(VISIT_ID);
        visitMapService.save(visit);
    }

    @Test
    void findByIdTest() {
        assertEquals(visit, visitMapService.findById(VISIT_ID));
    }

    @Test
    void saveTest() {
        assertNotNull(visitMapService.save(visit));
    }

    @Test
    void saveExceptionTest() {
        assertThrows(ObjectIsNullException.class, () -> visitMapService.save(null));
    }

    @Test
    void deleteTest() {
        visitMapService.delete(visit);
        assertEquals(0, visitMapService.findAll().size());
        assertNull(visitMapService.findById(VISIT_ID));
    }

    @Test
    void deleteByIdTest() {
        visitMapService.deleteById(visit.getId());
        assertEquals(0, visitMapService.findAll().size());
        assertNull(visitMapService.findById(VISIT_ID));
    }

    @Test
    void findAllTest() {
        assertEquals(1, visitMapService.findAll().size());
        assertTrue(visitMapService.findAll().contains(visit));
    }
}
    