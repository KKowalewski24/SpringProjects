package pl.kkowalewski.service.springdatajpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.kkowalewski.model.PetType;
import pl.kkowalewski.repository.PetTypeRepository;

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
class PetTypeJpaServiceTest {

    /*------------------------ FIELDS REGION ------------------------*/
    private static final String TYPE = "abc";
    private static final Long TYPE_ID = 1L;

    @Mock
    private PetTypeRepository petTypeRepository;

    @InjectMocks
    private PetTypeJpaService petTypeJpaService;

    private PetType petType;

    /*------------------------ METHODS REGION ------------------------*/
    @BeforeEach
    void setUp() {
        petType = new PetType(TYPE);
        petType.setId(TYPE_ID);
    }

    private Set<PetType> prepareSet() {
        return new HashSet<>(Arrays.asList(
                petType,
                new PetType("cde")
        ));
    }

    @Test
    void findByIdTest() {
        when(petTypeRepository.findById(anyLong())).thenReturn(Optional.of(petType));
        assertNotNull(petTypeJpaService.findById(TYPE_ID));
        verify(petTypeRepository).findById(anyLong());
    }

    @Test
    void saveTest() {
        when(petTypeRepository.save(any())).thenReturn(petType);
        assertNotNull(petTypeJpaService.save(petType));
        verify(petTypeRepository).save(any());
    }

    @Test
    void deleteTest() {
        petTypeRepository.delete(petType);
        verify(petTypeRepository).delete(any());
    }

    @Test
    void deleteByIdTest() {
        petTypeRepository.deleteById(petType.getId());
        verify(petTypeRepository).deleteById(anyLong());
    }

    @Test
    void findAllTest() {
        Set<PetType> petTypes = prepareSet();
        when(petTypeRepository.findAll()).thenReturn(petTypes);
        assertEquals(2, petTypeJpaService.findAll().size());
        verify(petTypeRepository).findAll();
    }
}
    