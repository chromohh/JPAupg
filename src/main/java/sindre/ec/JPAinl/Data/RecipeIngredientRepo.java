package sindre.ec.JPAinl.Data;

import org.springframework.data.repository.CrudRepository;
import sindre.ec.JPAinl.Entity.RecipeIngredient;

public interface RecipeIngredientRepo extends CrudRepository<RecipeIngredient, String> {

}
