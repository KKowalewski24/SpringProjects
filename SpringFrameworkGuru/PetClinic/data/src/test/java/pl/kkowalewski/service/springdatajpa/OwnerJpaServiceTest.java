package pl.kkowalewski.service.springdatajpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.kkowalewski.model.Owner;
import pl.kkowalewski.repository.OwnerRepository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerJpaServiceTest {

    /*------------------------ FIELDS REGION ------------------------*/
    private static final String LAST_NAME = "abc";
    private static final Long OWNER_ID = 1L;

    @Mock
    private OwnerRepository ownerRepository;

    @InjectMocks
    private OwnerJpaService ownerJpaService;

    private Owner ownerOne;

    /*------------------------ METHODS REGION ------------------------*/
    @BeforeEach
    void setUp() {
        ownerOne = new Owner("abc", LAST_NAME, "qqq", "waw", "123");
        ownerOne.setId(OWNER_ID);
    }

    private Set<Owner> prepareSet() {
        return new HashSet<>(Arrays.asList(
                ownerOne,
                new Owner("cde", "fgh", "zzz", "lodz", "456")
        ));
    }

    @Test
    void findByLastNameTest() {
        when(ownerRepository.findByLastName(any())).thenReturn(ownerOne);
        Owner smith = ownerJpaService.findByLastName(LAST_NAME);
        assertEquals(LAST_NAME, smith.getLastName());
        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findByIdTest() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(ownerOne));
        assertNotNull(ownerJpaService.findById(OWNER_ID));
        verify(ownerRepository).findById(anyLong());
    }

    @Test
    void findByIdNegativeTest() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
        assertNull(ownerJpaService.findById(OWNER_ID));
        verify(ownerRepository).findById(anyLong());

    }

    @Test
    void saveTest() {
        when(ownerRepository.save(any())).thenReturn(ownerOne);
        assertNotNull(ownerJpaService.save(ownerOne));
        verify(ownerRepository).save(any());
    }

    @Test
    void deleteTest() {
        ownerJpaService.delete(ownerOne);
        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteByIdTest() {
        ownerJpaService.deleteById(ownerOne.getId());
        verify(ownerRepository).deleteById(anyLong());
    }

    @Test
    void findAllTest() {
        Set<Owner> owners = prepareSet();
        when(ownerRepository.findAll()).thenReturn(owners);
        assertEquals(2, ownerJpaService.findAll().size());
        verify(ownerRepository).findAll();
    }
}
    