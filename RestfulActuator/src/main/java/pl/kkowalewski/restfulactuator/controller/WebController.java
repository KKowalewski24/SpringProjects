package pl.kkowalewski.restfulactuator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.kkowalewski.restfulactuator.model.Greeting;

import java.util.concurrent.atomic.AtomicLong;

@Controller
public class WebController {

    /*------------------------ FIELDS REGION ------------------------*/
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    /*------------------------ METHODS REGION ------------------------*/
    @GetMapping("/helloworld")
    @ResponseBody
    public Greeting sayHello(@RequestParam(name = "name",
            required = false, defaultValue = "Stranger") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
