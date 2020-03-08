package sindre.ec.JPAinl.Data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sindre.ec.JPAinl.Entity.Recipe;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecipeRepo extends CrudRepository<Recipe, Integer> {

    @Query("SELECT r FROM Recipe r WHERE r.recipeName LIKE %:recipeName%")
    List<Recipe> findByRecipeNameContains(@Param("recipeName") String Name);

    List<Recipe> findByRecipeIngredientsIngredientIngredientNameContains(String ingredientName); //Fungerar inte har testat allt!!!

    List<Recipe> findByRecipeCategoriesCategoryContainsIgnoreCase(String recipeCategory);

    @Query("SELECT r FROM Recipe r JOIN FETCH r.recipeCategories recipeCategory WHERE recipeCategory.category IN :category")
    List<Recipe> findRecipeByCategories(@Param("category")List<String> category);



}
