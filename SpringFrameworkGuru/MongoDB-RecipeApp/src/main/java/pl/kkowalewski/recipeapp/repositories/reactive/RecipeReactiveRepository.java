package pl.kkowalewski.recipeapp.repositories.reactive;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import pl.kkowalewski.recipeapp.domain.Recipe;

/**
 * Created by jt on 8/17/17.
 */
public interface RecipeReactiveRepository extends ReactiveMongoRepository<Recipe, String> {
}
