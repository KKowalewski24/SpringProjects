package pl.kkowalewski.service.springdatajpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.kkowalewski.model.Speciality;
import pl.kkowalewski.repository.SpecialityRepository;

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
class SpecialityJpaServiceTest {

    /*------------------------ FIELDS REGION ------------------------*/
    private static final String DESCRIPTION = "abc";
    private static final Long SPECIALITY_ID = 1L;

    @Mock
    private SpecialityRepository specialityRepository;

    @InjectMocks
    private SpecialityJpaService specialityJpaService;

    private Speciality speciality;

    /*------------------------ METHODS REGION ------------------------*/
    @BeforeEach
    void setUp() {
        speciality = new Speciality(DESCRIPTION);
        speciality.setId(SPECIALITY_ID);
    }

    private Set<Speciality> prepareSet() {
        return new HashSet<>(Arrays.asList(
                speciality,
                new Speciality("def")
        ));
    }

    @Test
    void findByIdTest() {
        when(specialityRepository.findById(anyLong())).thenReturn(Optional.of(speciality));
        assertNotNull(specialityJpaService.findById(SPECIALITY_ID));
        verify(specialityRepository).findById(anyLong());
    }

    @Test
    void saveTest() {
        when(specialityRepository.save(any())).thenReturn(speciality);
        assertNotNull(specialityJpaService.save(speciality));
        verify(specialityRepository).save(any());
    }

    @Test
    void deleteTest() {
        specialityJpaService.delete(speciality);
        verify(specialityRepository).delete(any());
    }

    @Test
    void deleteByIdTest() {
        specialityJpaService.deleteById(SPECIALITY_ID);
        verify(specialityRepository).deleteById(anyLong());
    }

    @Test
    void findAllTest() {
        Set<Speciality> specialities = prepareSet();
        when(specialityRepository.findAll()).thenReturn(specialities);
        assertEquals(2, specialityJpaService.findAll().size());
        verify(specialityRepository).findAll();
    }
}
    