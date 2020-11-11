package pl.kkowalewski.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pl.kkowalewski.model.Speciality;
import pl.kkowalewski.model.Vet;
import pl.kkowalewski.service.VetService;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class VetControllerTest {

    /*------------------------ FIELDS REGION ------------------------*/
    private static final String FIRST_NAME = "abc";
    private static final String LAST_NAME = "def";
    private static final Long VET_ID = 1L;

    @Mock
    private VetService vetService;

    @InjectMocks
    private VetController vetController;

    private Set<Vet> vetSet = new HashSet<>();
    private Vet vet;
    private MockMvc mockMvc;

    /*------------------------ METHODS REGION ------------------------*/
    @BeforeEach
    void setUp() {
        vet = new Vet(FIRST_NAME, LAST_NAME, new HashSet<>(Arrays.asList(new Speciality("qqq"))));
        vet.setId(VET_ID);
        vetSet.add(vet);
        mockMvc = MockMvcBuilders.standaloneSetup(vetController).build();
    }

    @Test
    void listVetsTest() throws Exception {
        when(vetService.findAll()).thenReturn(vetSet);
        mockMvc.perform(get(VetController.VETS))
                .andExpect(status().isOk())
                .andExpect(view().name(VetController.VETS_INDEX.substring(1)))
                .andExpect(model().attribute(VetController.VETS.substring(1), hasSize(1)));
    }

    @Test
    void listVetsHtmlTest() throws Exception {
        when(vetService.findAll()).thenReturn(vetSet);
        mockMvc.perform(get(VetController.VETS_HTML))
                .andExpect(status().isOk())
                .andExpect(view().name(VetController.VETS_INDEX.substring(1)))
                .andExpect(model().attribute(VetController.VETS.substring(1), hasSize(1)));
    }

    @Test
    void listVetsIndexTest() throws Exception {
        when(vetService.findAll()).thenReturn(vetSet);
        mockMvc.perform(get(VetController.VETS_INDEX))
                .andExpect(status().isOk())
                .andExpect(view().name(VetController.VETS_INDEX.substring(1)))
                .andExpect(model().attribute(VetController.VETS.substring(1), hasSize(1)));
    }

    @Test
    void listVetsIndexHtmlTest() throws Exception {
        when(vetService.findAll()).thenReturn(vetSet);
        mockMvc.perform(get(VetController.VETS_INDEX_HTML))
                .andExpect(status().isOk())
                .andExpect(view().name(VetController.VETS_INDEX.substring(1)))
                .andExpect(model().attribute(VetController.VETS.substring(1), hasSize(1)));
    }
}
    