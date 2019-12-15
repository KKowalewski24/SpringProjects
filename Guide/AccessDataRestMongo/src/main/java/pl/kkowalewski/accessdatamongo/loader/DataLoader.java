package pl.kkowalewski.accessdatamongo.loader;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pl.kkowalewski.accessdatamongo.model.Person;
import pl.kkowalewski.accessdatamongo.repository.PersonRepository;

@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

    /*------------------------ FIELDS REGION ------------------------*/
    private final PersonRepository personRepository;

    /*------------------------ METHODS REGION ------------------------*/
    public DataLoader(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        personRepository.save(new Person("Kamil", "Kowalewski"));
    }
}
