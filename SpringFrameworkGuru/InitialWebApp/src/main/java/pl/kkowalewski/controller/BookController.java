package pl.kkowalewski.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kkowalewski.repository.BookRepository;

@Controller
public class BookController {

    /*------------------------ FIELDS REGION ------------------------*/
    private BookRepository bookRepository;

    /*------------------------ METHODS REGION ------------------------*/
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public String getBooks(final Model model) {
        model.addAttribute("books", bookRepository.findAll());

        return "books";
    }
}
