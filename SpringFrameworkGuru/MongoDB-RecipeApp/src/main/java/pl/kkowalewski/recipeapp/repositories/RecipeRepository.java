package pl.kkowalewski.recipeapp.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.kkowalewski.recipeapp.domain.Recipe;

/**
 * Created by jt on 6/13/17.
 */
public interface RecipeRepository extends CrudRepository<Recipe, String> {
}
