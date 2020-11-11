package pl.kkowalewski.restclient.service;

import pl.kkowalewski.restclient.api.model.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ApiService {
    Flux<User> prepareUsers(Mono<Integer> limit);
}
