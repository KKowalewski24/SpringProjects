package pl.kkowalewski.restclient.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import pl.kkowalewski.restclient.api.model.User;
import pl.kkowalewski.restclient.api.model.UserData;
import pl.kkowalewski.restclient.controller.UserController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ApiServiceImpl implements ApiService {

    /*------------------------ FIELDS REGION ------------------------*/
    private final String apiUrl;

    /*------------------------ METHODS REGION ------------------------*/
    public ApiServiceImpl(@Value("${api.url}") String apiUrl) {
        this.apiUrl = apiUrl;
    }

    @Override
    public Flux<User> prepareUsers(Mono<Integer> limit) {
        return WebClient.create(apiUrl).get().uri(uriBuilder -> uriBuilder
                .queryParam(UserController.LIMIT, limit.block()).build())
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .flatMap(clientResponse -> clientResponse.bodyToMono(UserData.class))
                .flatMapIterable(UserData::getData);
    }
}
