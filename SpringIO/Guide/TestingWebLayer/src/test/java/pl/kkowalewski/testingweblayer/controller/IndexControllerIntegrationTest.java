package pl.kkowalewski.testingweblayer.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static pl.kkowalewski.testingweblayer.constants.Constant.INDEX;
import static pl.kkowalewski.testingweblayer.constants.Constant.SLASH;

@AutoConfigureMockMvc
@SpringBootTest
@ExtendWith(SpringExtension.class)
class IndexControllerIntegrationTest {

    /*------------------------ FIELDS REGION ------------------------*/
    private final MockMvc mockMvc;

    /*------------------------ METHODS REGION ------------------------*/
    @Autowired
    public IndexControllerIntegrationTest(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    void indexTest() throws Exception {
        mockMvc.perform(get(SLASH))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(INDEX)));
    }
}
