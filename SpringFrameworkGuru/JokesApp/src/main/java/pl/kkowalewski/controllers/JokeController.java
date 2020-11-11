package pl.kkowalewski.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kkowalewski.services.JokeService;

@Controller
public class JokeController {

    /*------------------------ FIELDS REGION ------------------------*/
    public static final String DESCRIPTION = "chucknorris";
    private JokeService jokeService;

    /*------------------------ METHODS REGION ------------------------*/
    public JokeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @RequestMapping({"/", ""})
    public String showJoke(Model model) {
        model.addAttribute("joke", jokeService.getJoke());

        return DESCRIPTION;
    }
}
