package pl.kkowalewski.repository;

import org.springframework.data.repository.CrudRepository;
import pl.kkowalewski.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
