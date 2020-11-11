package pl.kkowalewski.restclient.controller;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;

@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

    /*------------------------ FIELDS REGION ------------------------*/
    @Autowired
    private ApplicationContext applicationContext;

    private WebTestClient webTestClient;

    /*------------------------ METHODS REGION ------------------------*/
    @Before
    public void setUp() {
        webTestClient = WebTestClient.bindToApplicationContext(applicationContext).build();
    }

    @Test
    public void indexTest() {
        webTestClient.get().uri(UserController.SLASH)
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    public void formPostTest() {
        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("limit", "3");

        webTestClient.post().uri(UserController.USERS)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .body(BodyInserters.fromFormData(formData))
                .exchange()
                .expectStatus().isOk();
    }
}
