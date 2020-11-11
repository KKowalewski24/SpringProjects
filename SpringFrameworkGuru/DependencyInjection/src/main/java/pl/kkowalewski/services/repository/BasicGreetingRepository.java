package pl.kkowalewski.services.repository;

import org.springframework.stereotype.Service;

@Service
public class BasicGreetingRepository implements GreetingRepository {

    /*------------------------ FIELDS REGION ------------------------*/
    public static final String[] MESSAGE = {
            "Welcome People",
            "Glowny powitalny serwis",
            "Primarer Begrubungsdienst"
    };

    /*------------------------ METHODS REGION ------------------------*/

    @Override
    public String getEnglishGreeting() {
        return MESSAGE[0];
    }

    @Override
    public String getPolishGreeting() {
        return MESSAGE[1];
    }

    @Override
    public String getGermanGreeting() {
        return MESSAGE[2];
    }
}
