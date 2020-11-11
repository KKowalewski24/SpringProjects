package pl.kkowalewski.repository;

import org.springframework.data.repository.CrudRepository;
import pl.kkowalewski.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
