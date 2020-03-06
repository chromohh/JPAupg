package sindre.ec.JPAinl.Data;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sindre.ec.JPAinl.Entity.Recipe;

import java.util.List;
import java.util.Set;

@Repository
public interface RecipeRepo extends CrudRepository<Recipe, Integer> {

    @Query("SELECT r FROM Recipe r WHERE r.recipeName LIKE %:recipeName%")
    List<Recipe> findByRecipeNameContains(@Param("recipeName") String Name);

    List<Recipe> findByRecipeIngredientsIngredientIngredientNameContains(String ingredientName); //Fungerar inte har testat

    List<Recipe> findByRecipeCategoriesCategoryContainsIgnoreCase(String recipeCategory);



}
