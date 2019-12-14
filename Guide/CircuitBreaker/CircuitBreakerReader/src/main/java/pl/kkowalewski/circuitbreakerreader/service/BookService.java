package pl.kkowalewski.circuitbreakerreader.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class BookService {

    /*------------------------ FIELDS REGION ------------------------*/
    private final RestTemplate restTemplate;

    /*------------------------ METHODS REGION ------------------------*/
    public BookService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @HystrixCommand(fallbackMethod = "reliable")
    public String readingList() {
        return restTemplate.getForObject(
                URI.create("http://localhost:8090/recommended"), String.class);
    }

    public String reliable() {
        return "Cloud Native Java (O'Reilly)";
    }
}
