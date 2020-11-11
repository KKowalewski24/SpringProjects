package pl.kkowalewski.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@ExtendWith(MockitoExtension.class)
class ErrorControllerTest {

    /*------------------------ FIELDS REGION ------------------------*/
    private ErrorController errorController = new ErrorController();
    private MockMvc mockMvc = MockMvcBuilders.standaloneSetup(errorController).build();

    /*------------------------ METHODS REGION ------------------------*/
    @Test
    void errorTest() throws Exception {
        mockMvc.perform(get(ErrorController.OUPS))
                .andExpect(status().isOk())
                .andExpect(view().name(ErrorController.ERROR_INDEX.substring(1)));
    }

    @Test
    void errorHtmlTest() throws Exception {
        mockMvc.perform(get(ErrorController.OUPS_HTML))
                .andExpect(status().isOk())
                .andExpect(view().name(ErrorController.ERROR_INDEX.substring(1)));
    }

    @Test
    void errorIndexTest() throws Exception {
        mockMvc.perform(get(ErrorController.ERROR_INDEX))
                .andExpect(status().isOk())
                .andExpect(view().name(ErrorController.ERROR_INDEX.substring(1)));
    }

    @Test
    void errorIndexHtmlTest() throws Exception {
        mockMvc.perform(get(ErrorController.ERROR_INDEX_HTML))
                .andExpect(status().isOk())
                .andExpect(view().name(ErrorController.ERROR_INDEX.substring(1)));
    }
}
    