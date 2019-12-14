package pl.kkowalewski.circuitbreakerreader.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kkowalewski.circuitbreakerreader.service.BookService;

@RestController
public class BookController {

    /*------------------------ FIELDS REGION ------------------------*/
    private final BookService bookService;

    /*------------------------ METHODS REGION ------------------------*/
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/read")
    public String read() {
        return bookService.readingList();
    }
}
