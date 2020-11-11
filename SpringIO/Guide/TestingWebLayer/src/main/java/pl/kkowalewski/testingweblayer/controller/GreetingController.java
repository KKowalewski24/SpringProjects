package pl.kkowalewski.testingweblayer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.kkowalewski.testingweblayer.service.GreetingService;

import static pl.kkowalewski.testingweblayer.constants.Constant.GREETING_PATH;

@Controller
public class GreetingController {

    /*------------------------ FIELDS REGION ------------------------*/
    private final GreetingService greetingService;

    /*------------------------ METHODS REGION ------------------------*/
    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @ResponseBody
    @RequestMapping(GREETING_PATH)
    public String greeting() {
        return greetingService.greet();
    }
}
