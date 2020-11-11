package pl.kkowalewski.testingweblayer.service;

import org.springframework.stereotype.Service;

import static pl.kkowalewski.testingweblayer.constants.Constant.HELLO_WORLD;

@Service
public class GreetingService {

    /*------------------------ FIELDS REGION ------------------------*/

    /*------------------------ METHODS REGION ------------------------*/
    public String greet() {
        return HELLO_WORLD;
    }
}
