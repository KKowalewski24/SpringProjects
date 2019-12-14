package pl.kkowalewski.cachedata.repository;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import pl.kkowalewski.cachedata.model.Book;

@Component
public class BookRepositoryImpl implements BookRepository {

    /*------------------------ FIELDS REGION ------------------------*/

    /*------------------------ METHODS REGION ------------------------*/
    private void simulateSlowService() {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

    @Cacheable("books")
    @Override
    public Book getByIsbn(String isbn) {
        simulateSlowService();
        return new Book(isbn, "Book");
    }
}
