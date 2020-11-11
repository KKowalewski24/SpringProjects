package pl.kkowalewski.repository;

import org.springframework.data.repository.CrudRepository;
import pl.kkowalewski.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {

}
