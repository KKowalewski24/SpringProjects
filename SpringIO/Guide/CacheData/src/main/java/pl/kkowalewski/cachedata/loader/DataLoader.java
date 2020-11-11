package pl.kkowalewski.cachedata.loader;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.kkowalewski.cachedata.repository.BookRepository;

@Slf4j
@Component
public class DataLoader implements CommandLineRunner {

    /*------------------------ FIELDS REGION ------------------------*/
    private final BookRepository bookRepository;

    /*------------------------ METHODS REGION ------------------------*/
    public DataLoader(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info(".... Fetching books");
        log.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
        log.info("isbn-4567 -->" + bookRepository.getByIsbn("isbn-4567"));
        log.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
        log.info("isbn-4567 -->" + bookRepository.getByIsbn("isbn-4567"));
        log.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
        log.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
    }
}
