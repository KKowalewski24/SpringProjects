package pl.kkowalewski.recipeapp.repositories.reactive;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import pl.kkowalewski.recipeapp.domain.UnitOfMeasure;
import reactor.core.publisher.Mono;

/**
 * Created by jt on 8/17/17.
 */
public interface UnitOfMeasureReactiveRepository extends ReactiveMongoRepository<UnitOfMeasure,
        String> {

    Mono<UnitOfMeasure> findByDescription(String description);
}
