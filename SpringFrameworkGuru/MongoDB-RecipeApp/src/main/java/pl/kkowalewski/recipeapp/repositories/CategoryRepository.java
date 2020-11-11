package pl.kkowalewski.recipeapp.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.kkowalewski.recipeapp.domain.Category;

import java.util.Optional;

/**
 * Created by jt on 6/13/17.
 */
public interface CategoryRepository extends CrudRepository<Category, String> {

    Optional<Category> findByDescription(String description);
}
