package pl.kkowalewski.handleformsubmit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.kkowalewski.handleformsubmit.model.Greeting;

@Controller
public class GreetingController {

    /*------------------------ FIELDS REGION ------------------------*/
    public static final String GREETING = "greeting";
    public static final String GREETING_PATH = "/" + GREETING;
    public static final String RESULT = "result";

    /*------------------------ METHODS REGION ------------------------*/
    @GetMapping(GREETING_PATH)
    public String greetingForm(Model model) {
        model.addAttribute(GREETING, new Greeting());

        return GREETING;
    }

    @PostMapping(GREETING_PATH)
    public String greetingSubmit(@ModelAttribute Greeting greeting) {
        return RESULT;
    }
}
