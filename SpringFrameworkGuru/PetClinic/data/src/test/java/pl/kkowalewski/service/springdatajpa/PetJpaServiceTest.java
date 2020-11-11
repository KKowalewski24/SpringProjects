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
import pl.kkowalewski.repository.PetRepository;

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
class PetJpaServiceTest {

    /*------------------------ FIELDS REGION ------------------------*/
    private static final Long PET_ID = 1L;
    private static final String PET_NAME = "petOne";

    @Mock
    private PetRepository petRepository;

    @InjectMocks
    private PetJpaService petJpaService;

    private Pet pet;
    private LocalDate today = LocalDate.now();

    /*------------------------ METHODS REGION ------------------------*/
    @BeforeEach
    void setUp() {
        pet = new Pet(PET_NAME, new PetType("A"),
                new Owner("abc", "cde", "qqq", "waw", "123"), today);
        pet.setId(PET_ID);
    }

    private Set<Pet> prepareSet() {
        return new HashSet<>(Arrays.asList(
                pet,
                new Pet("petTwo", new PetType("B"),
                        new Owner("eee", "fff", "www", "lodz", "456"), today)
        ));
    }

    @Test
    void findByIdTest() {
        when(petRepository.findById(anyLong())).thenReturn(Optional.of(pet));
        assertNotNull(petJpaService.findById(PET_ID));
    }

    @Test
    void saveTest() {
        when(petRepository.save(any())).thenReturn(pet);
        assertNotNull(petJpaService.save(pet));
        verify(petRepository).save(pet);
    }

    @Test
    void deleteTest() {
        petJpaService.delete(pet);
        verify(petRepository).delete(any());
    }

    @Test
    void deleteByIdTest() {
        petJpaService.deleteById(PET_ID);
        verify(petRepository).deleteById(anyLong());
    }

    @Test
    void findAllTest() {
        Set<Pet> pets = prepareSet();
        when(petRepository.findAll()).thenReturn(pets);
        assertEquals(2, petJpaService.findAll().size());
        verify(petRepository).findAll();
    }
}
    