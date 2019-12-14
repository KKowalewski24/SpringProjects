package pl.kkowalewski.asyncmethod.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.kkowalewski.asyncmethod.model.User;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class GitHubLookupService {

    /*------------------------ FIELDS REGION ------------------------*/
    private final RestTemplate restTemplate;

    /*------------------------ METHODS REGION ------------------------*/
    public GitHubLookupService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Async
    public CompletableFuture<User> findUser(String user) throws InterruptedException {
        log.info("Looking up " + user);
        String url = "https://api.github.com/" + user + "/%s";
        User results = restTemplate.getForObject(url, User.class);
        Thread.sleep(1000L);

        return CompletableFuture.completedFuture(results);
    }
}
