package pl.kkowalewski.repository;

import org.springframework.data.repository.CrudRepository;
import pl.kkowalewski.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {

}
