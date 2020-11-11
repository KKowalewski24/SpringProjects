package pl.kkowalewski.repository;

import org.springframework.data.repository.CrudRepository;
import pl.kkowalewski.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {

}
