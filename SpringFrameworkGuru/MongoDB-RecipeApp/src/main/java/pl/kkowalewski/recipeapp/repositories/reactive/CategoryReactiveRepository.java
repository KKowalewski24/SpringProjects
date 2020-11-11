package pl.kkowalewski.recipeapp.repositories.reactive;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import pl.kkowalewski.recipeapp.domain.Category;
import reactor.core.publisher.Mono;

/**
 * Created by jt on 8/17/17.
 */
public interface CategoryReactiveRepository extends ReactiveMongoRepository<Category, String> {

    Mono<Category> findByDescription(String description);
}
