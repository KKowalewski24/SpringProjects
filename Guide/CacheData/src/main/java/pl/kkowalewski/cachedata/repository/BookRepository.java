package pl.kkowalewski.cachedata.repository;

import pl.kkowalewski.cachedata.model.Book;

public interface BookRepository {
    Book getByIsbn(String isbn);
}
