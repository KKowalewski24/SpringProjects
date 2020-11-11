package pl.kkowalewski.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pl.kkowalewski.model.Author;
import pl.kkowalewski.model.Book;
import pl.kkowalewski.model.Publisher;
import pl.kkowalewski.repository.AuthorRepository;
import pl.kkowalewski.repository.BookRepository;
import pl.kkowalewski.repository.PublisherRepository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    /*------------------------ FIELDS REGION ------------------------*/
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    /*------------------------ METHODS REGION ------------------------*/

    public DevBootstrap(final AuthorRepository authorRepository,
                        final BookRepository bookRepository,
                        final PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    private Publisher preparePublisher(String name, String address) {
        Publisher publisher = new Publisher(name, address);
        publisherRepository.save(publisher);

        return publisher;
    }

    private Author prepareAuthor(String firstName, String lastName, Set<Book> books) {
        Author author = new Author(firstName, lastName, books);
        authorRepository.save(author);

        return author;
    }

    private Book prepareBook(String title, String isbn, Publisher publisher) {
        Book book = new Book(title, isbn, publisher);
        bookRepository.save(book);

        return book;
    }

    private void prepareAuthorAndBook(String firstName, String lastName, Book... books) {
        Author author = prepareAuthor(firstName, lastName, new HashSet<>(Arrays.asList(books)));
        for (Book it : books) {
            it.getAuthors().add(author);
        }
    }

    private void initData() {
        Publisher publisher = preparePublisher("Vicks", "Warsaw Street 12");

        prepareAuthorAndBook("Kamil", "Kowalewski",
                new Book("Abc", "123", publisher));
        prepareAuthorAndBook("Jan", "Kowalski",
                new Book("Fgh", "456", publisher));
    }

    @Override
    public void onApplicationEvent(final ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
