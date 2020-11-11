package pl.kkowalewski.repository;

import org.springframework.data.repository.CrudRepository;
import pl.kkowalewski.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {

}
