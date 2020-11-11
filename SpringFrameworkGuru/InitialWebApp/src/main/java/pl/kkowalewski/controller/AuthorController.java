package pl.kkowalewski.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kkowalewski.repository.AuthorRepository;

@Controller
public class AuthorController {

    /*------------------------ FIELDS REGION ------------------------*/
    private AuthorRepository authorRepository;

    /*------------------------ METHODS REGION ------------------------*/
    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/authors")
    public String getAuthors(final Model model) {
        model.addAttribute("authors", authorRepository.findAll());

        return "authors";
    }
}
