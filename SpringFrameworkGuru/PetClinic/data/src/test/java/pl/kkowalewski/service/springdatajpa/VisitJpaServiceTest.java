package pl.kkowalewski.service.springdatajpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.kkowalewski.model.Owner;
import pl.kkowalewski.model.Pet;
import pl.kkowalewski.model.PetType;
import pl.kkowalewski.model.Visit;
import pl.kkowalewski.repository.VisitRepository;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VisitJpaServiceTest {

    /*------------------------ FIELDS REGION ------------------------*/
    private static final String DESCRIPTION = "abc";
    private static final Long VISIT_ID = 1L;
    private static final LocalDate today = LocalDate.now();

    @Mock
    private VisitRepository visitRepository;

    @InjectMocks
    private VisitJpaService visitJpaService;

    private Visit visit;

    /*------------------------ METHODS REGION ------------------------*/
    @BeforeEach
    void setUp() {
        visit = new Visit(today, DESCRIPTION,
                new Pet("petOne", new PetType("A"),
                        new Owner("abc", "cde", "qqq", "waw", "123"), today));
        visit.setId(VISIT_ID);
    }

    private Set<Visit> prepareSet() {
        return new HashSet<>(Arrays.asList(
                visit,
                new Visit(today, "def", new Pet("petOne", new PetType("A"),
                        new Owner("abc", "cde", "qqq", "waw", "123"), today))
        ));
    }

    @Test
    void findByIdTest() {
        when(visitRepository.findById(anyLong())).thenReturn(Optional.of(visit));
        assertNotNull(visitJpaService.findById(VISIT_ID));
        verify(visitRepository).findById(anyLong());
    }

    @Test
    void saveTest() {
        when(visitRepository.save(any())).thenReturn(visit);
        assertNotNull(visitJpaService.save(visit));
        verify(visitRepository).save(any());
    }

    @Test
    void deleteTest() {
        visitJpaService.delete(visit);
        verify(visitRepository).delete(any());
    }

    @Test
    void deleteByIdTest() {
        visitJpaService.deleteById(VISIT_ID);
        verify(visitRepository).deleteById(anyLong());
    }

    @Test
    void findAllTest() {
        Set<Visit> visits = prepareSet();
        when(visitRepository.findAll()).thenReturn(visits);
        assertEquals(2, visitJpaService.findAll().size());
        verify(visitRepository).findAll();
    }
}
    