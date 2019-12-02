package pl.kkowalewski.batchservice.processor;

import org.springframework.batch.item.ItemProcessor;
import pl.kkowalewski.batchservice.model.Person;

public class PersonItemProcessor implements ItemProcessor<Person, Person> {

    /*------------------------ FIELDS REGION ------------------------*/

    /*------------------------ METHODS REGION ------------------------*/
    @Override
    public Person process(Person person) throws Exception {
        return new Person(person.getFirstName().toUpperCase(),
                person.getLastName().toUpperCase());
    }
}
