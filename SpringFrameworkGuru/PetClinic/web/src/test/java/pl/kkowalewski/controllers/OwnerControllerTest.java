package pl.kkowalewski.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pl.kkowalewski.model.Owner;
import pl.kkowalewski.service.OwnerService;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

    /*------------------------ FIELDS REGION ------------------------*/
    private static final String LAST_NAME = "abc";
    private static final Long OWNER_ID = 1L;

    @Mock
    private OwnerService ownerService;

    @InjectMocks
    private OwnerController ownerController;

    private Set<Owner> ownerSet = new HashSet<>();
    private Owner ownerOne;
    private MockMvc mockMvc;

    /*------------------------ METHODS REGION ------------------------*/
    @BeforeEach
    void setUp() {
        ownerOne = new Owner("abc", LAST_NAME, "qqq", "waw", "123");
        ownerOne.setId(OWNER_ID);
        ownerSet.add(ownerOne);
        mockMvc = MockMvcBuilders.standaloneSetup(ownerController).build();
    }

    @Test
    void listOwnersTest() throws Exception {
        when(ownerService.findAll()).thenReturn(ownerSet);

        mockMvc.perform(get(OwnerController.OWNERS))
                .andExpect(status().isOk())
                .andExpect(view().name(OwnerController.OWNERS_INDEX.substring(1)))
                .andExpect(model().attribute(OwnerController.OWNERS.substring(1), hasSize(1)));
    }

    @Test
    void listOwnersByIndexTest() throws Exception {
        when(ownerService.findAll()).thenReturn(ownerSet);

        mockMvc.perform(get(OwnerController.OWNERS_INDEX))
                .andExpect(status().isOk())
                .andExpect(view().name(OwnerController.OWNERS_INDEX.substring(1)))
                .andExpect(model().attribute(OwnerController.OWNERS.substring(1), hasSize(1)));
    }

    @Test
    void listOwnersByIndexHtmlTest() throws Exception {
        when(ownerService.findAll()).thenReturn(ownerSet);

        mockMvc.perform(get(OwnerController.OWNERS_INDEX_HTML))
                .andExpect(status().isOk())
                .andExpect(view().name(OwnerController.OWNERS_INDEX.substring(1)))
                .andExpect(model().attribute(OwnerController.OWNERS.substring(1), hasSize(1)));
    }

    @Test
    void findOwnersTest() throws Exception {
        mockMvc.perform(get(OwnerController.OWNERS_FIND))
                .andExpect(status().isOk())
                .andExpect(view().name("notImplemented"));

        verifyZeroInteractions(ownerService);
    }

    @Test
    void showOwnerTest() throws Exception {
        when(ownerService.findById(anyLong())).thenReturn(ownerOne);

        mockMvc.perform(get(OwnerController.OWNERS + "/123"))
                .andExpect(status().isOk())
                .andExpect(view().name(OwnerController.OWNERS_DETAILS))
                .andExpect(model().attribute(OwnerController.OWNER,
                        hasProperty("id", is(OWNER_ID))));
    }
}
    