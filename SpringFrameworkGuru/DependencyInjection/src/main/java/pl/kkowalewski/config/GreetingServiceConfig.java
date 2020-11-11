package pl.kkowalewski.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import pl.kkowalewski.services.GreetingService;
import pl.kkowalewski.services.GreetingServiceFactory;
import pl.kkowalewski.services.repository.GreetingRepository;

@Configuration
public class GreetingServiceConfig {

    /*------------------------ FIELDS REGION ------------------------*/

    /*------------------------ METHODS REGION ------------------------*/
    @Bean
    GreetingServiceFactory makeGreetingService(GreetingRepository repository) {
        return new GreetingServiceFactory(repository);
    }

    @Bean
    @Primary
    @Profile({"default", "en"})
    GreetingService primaryGreetingService(GreetingServiceFactory factory) {
        return factory.createGreetingService("en");
    }

    @Bean
    @Primary
    @Profile({"pl"})
    GreetingService primaryPolishGreetingService(GreetingServiceFactory factory) {
        return factory.createGreetingService("pl");
    }

    @Bean
    @Primary
    @Profile({"de"})
    GreetingService primaryGermanGreetingService(GreetingServiceFactory factory) {
        return factory.createGreetingService("de");
    }
}
