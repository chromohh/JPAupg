package sindre.ec.JPAinl.Data;

import org.springframework.data.jdbc.repository.query.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.*;
import org.springframework.stereotype.Repository;
import sindre.ec.JPAinl.Entity.Ingredient;

import java.util.List;
import java.util.Optional;

@Repository
public interface IngredientRepo extends CrudRepository<Ingredient, Integer> {

    Optional<Ingredient> findByIngredientName(String Name);

    @Query("SELECT i FROM Ingredient i WHERE i.ingredientName LIKE %:ingredientName%")
    List<Ingredient> findByIngredientNameContains(@Param("ingredientName") String Name);

}
