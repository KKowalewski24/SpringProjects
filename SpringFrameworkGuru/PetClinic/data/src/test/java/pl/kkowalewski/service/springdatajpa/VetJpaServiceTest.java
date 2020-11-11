package pl.kkowalewski.service.springdatajpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.kkowalewski.model.Speciality;
import pl.kkowalewski.model.Vet;
import pl.kkowalewski.repository.VetRepository;

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
class VetJpaServiceTest {

    /*------------------------ FIELDS REGION ------------------------*/
    private static final String FIRST_NAME = "abc";
    private static final String LAST_NAME = "def";
    private static final Long VET_ID = 1L;

    @Mock
    private VetRepository vetRepository;

    @InjectMocks
    private VetJpaService vetJpaService;

    private Vet vet;

    /*------------------------ METHODS REGION ------------------------*/
    @BeforeEach
    void setUp() {
        vet = new Vet(FIRST_NAME, LAST_NAME, new HashSet<>(Arrays.asList(new Speciality("qqq"))));
        vet.setId(VET_ID);
    }

    private Set<Vet> prepareSet() {
        return new HashSet<>(Arrays.asList(
                vet,
                new Vet("zzz", "yyy", new HashSet<>(Arrays.asList(new Speciality("wwww"))))
        ));
    }

    @Test
    void findByIdTest() {
        when(vetRepository.findById(anyLong())).thenReturn(Optional.of(vet));
        assertNotNull(vetJpaService.findById(VET_ID));
        verify(vetRepository).findById(anyLong());
    }

    @Test
    void saveTest() {
        when(vetRepository.save(any())).thenReturn(vet);
        assertNotNull(vetJpaService.save(vet));
        verify(vetRepository).save(any());
    }

    @Test
    void deleteTest() {
        vetJpaService.delete(vet);
        verify(vetRepository).delete(any());
    }

    @Test
    void deleteByIdTest() {
        vetJpaService.deleteById(VET_ID);
        verify(vetRepository).deleteById(anyLong());
    }

    @Test
    void findAllTest() {
        Set<Vet> vets = prepareSet();
        when(vetRepository.findAll()).thenReturn(vets);
        assertEquals(2, vetJpaService.findAll().size());
        verify(vetRepository).findAll();
    }
}
    