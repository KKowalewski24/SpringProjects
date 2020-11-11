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
class IndexControllerTest {

    /*------------------------ FIELDS REGION ------------------------*/
    private IndexController indexController = new IndexController();
    private MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();

    /*------------------------ METHODS REGION ------------------------*/
    @Test
    void indexRootTest() throws Exception {
        mockMvc.perform(get(IndexController.ROOT))
                .andExpect(status().isOk())
                .andExpect(view().name(IndexController.INDEX.substring(1)));
    }

    @Test
    void indexSlashTest() throws Exception {
        mockMvc.perform(get(IndexController.SLASH))
                .andExpect(status().isOk())
                .andExpect(view().name(IndexController.INDEX.substring(1)));
    }

//    @Test
//    void indexIndexTest() throws Exception {
//        mockMvc.perform(get(IndexController.INDEX))
//                .andExpect(status().isOk())
//                .andExpect(view().name(IndexController.INDEX.substring(1)));
//    }

    @Test
    void indexIndexHtmlTest() throws Exception {
        mockMvc.perform(get(IndexController.INDEX_HTML))
                .andExpect(status().isOk())
                .andExpect(view().name(IndexController.INDEX.substring(1)));
    }
}
    