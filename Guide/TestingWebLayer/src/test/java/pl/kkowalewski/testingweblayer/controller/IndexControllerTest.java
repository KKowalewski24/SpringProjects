package pl.kkowalewski.testingweblayer.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static pl.kkowalewski.testingweblayer.constants.Constant.INDEX;
import static pl.kkowalewski.testingweblayer.constants.Constant.LOCALHOST;
import static pl.kkowalewski.testingweblayer.constants.Constant.SLASH;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IndexControllerTest {

    /*------------------------ FIELDS REGION ------------------------*/
    @LocalServerPort
    private int port;
    private final IndexController indexController;
    private final TestRestTemplate testRestTemplate;

    /*------------------------ METHODS REGION ------------------------*/
    @Autowired
    public IndexControllerTest(IndexController indexController,
                               TestRestTemplate testRestTemplate) {
        this.indexController = indexController;
        this.testRestTemplate = testRestTemplate;
    }

    @Test
    void contextLoads() {
        assertNotNull(indexController);
    }

    @Test
    void indexTest() {
        assertEquals(INDEX, testRestTemplate
                .getForObject(LOCALHOST + port + SLASH, String.class));
    }
}
