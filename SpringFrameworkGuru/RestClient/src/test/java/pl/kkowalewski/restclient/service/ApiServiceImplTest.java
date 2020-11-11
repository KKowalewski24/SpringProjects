package pl.kkowalewski.restclient.service;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Mono;

import static org.junit.Assert.assertEquals;

@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiServiceImplTest {

    /*------------------------ FIELDS REGION ------------------------*/
    private static final int NUMBER_OF_PERSONS = 3;

    @Autowired
    private ApiService apiService;

    /*------------------------ METHODS REGION ------------------------*/

    @Test
    public void prepareUsersTest() {
//        assertEquals(NUMBER_OF_PERSONS, apiService.prepareUsers(NUMBER_OF_PERSONS).size());
    }
}
    