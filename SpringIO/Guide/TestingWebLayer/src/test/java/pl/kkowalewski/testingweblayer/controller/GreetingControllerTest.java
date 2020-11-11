package pl.kkowalewski.testingweblayer.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import pl.kkowalewski.testingweblayer.service.GreetingService;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static pl.kkowalewski.testingweblayer.constants.Constant.GREETING_PATH;
import static pl.kkowalewski.testingweblayer.constants.Constant.HELLO_WORLD;

@WebMvcTest
@ExtendWith(SpringExtension.class)
class GreetingControllerTest {

    /*------------------------ FIELDS REGION ------------------------*/
    private final MockMvc mockMvc;

    @MockBean
    private GreetingService greetingService;

    /*------------------------ METHODS REGION ------------------------*/
    @Autowired
    public GreetingControllerTest(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    void greetingTest() throws Exception {
        when(greetingService.greet()).thenReturn(HELLO_WORLD);

        mockMvc.perform(get(GREETING_PATH))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(HELLO_WORLD)));
    }
}
