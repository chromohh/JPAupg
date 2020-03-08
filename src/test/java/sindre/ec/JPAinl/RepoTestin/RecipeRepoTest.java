package sindre.ec.JPAinl.RepoTestin;

import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;
import sindre.ec.JPAinl.Data.RecipeInstructionRepo;
import sindre.ec.JPAinl.Data.RecipeRepo;
import sindre.ec.JPAinl.Entity.*;

import java.util.*;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@TestPropertySource(locations="classpath:resources.properties")
public class RecipeRepoTest {

    @Autowired private RecipeRepo testObject;

    @Autowired private TestEntityManager em;

    private List<RecipeIngredient> testLRI1;
    private List<RecipeCategory> testLRC1;
    private Recipe testRecipe;

    private List<Recipe> data(){
        return Arrays.asList();
    }
    @BeforeEach
    void setup(){
        RecipeIngredient common = new RecipeIngredient(new Ingredient("sallad"), 12, Measurement.ST);

        List<RecipeIngredient> testRI1 = Arrays.asList(new RecipeIngredient(new Ingredient("Choklad"), 100, Measurement.G),
                new RecipeIngredient(new Ingredient("Sura Nappar"), 15, Measurement.ST),
                new RecipeIngredient(new Ingredient("Colaflaskor"), 50, Measurement.TSK),
                new RecipeIngredient(new Ingredient("Paj"), 1, Measurement.DL));
        List<RecipeIngredient> testRI2 = Arrays.asList(new RecipeIngredient(new Ingredient("Tomat"), 1000, Measurement.TSK),
                new RecipeIngredient(new Ingredient("Soppa"), 12, Measurement.ST), common);
        List<RecipeIngredient> testRI3 = Arrays.asList(new RecipeIngredient(new Ingredient("Kebab"), 100, Measurement.ST),
                new RecipeIngredient(new Ingredient("Bröd"), 300, Measurement.G), common);

        testLRI1 = testRI1;

        RecipeCategory category1 = new RecipeCategory("Gott");
        RecipeCategory category2 = new RecipeCategory("Äckligt");

        List<RecipeCategory> testRC1 = Arrays.asList(category1);
        List<RecipeCategory> testRC2 = Arrays.asList(category2);
        List<RecipeCategory> testRC3 = Arrays.asList(category1, category2);


        testLRC1 = testRC1;

        testObject.save(new Recipe ("Godis Paj", testRI1, testRC1, new RecipeInstruction("baka Paj")));
        testObject.save(new Recipe("Tomato Supyb", testRI2, testRC2, new RecipeInstruction("baka soppan")));
        testRecipe = testObject.save(new Recipe("Kebab", testRI3, testRC3, new RecipeInstruction("baka kebab1")));
        em.flush();
    }

    @Test
    void injectionsNotNull(){
        assertNotNull(testObject);
        assertNotNull(em);
    }

    @Test
    void testAddUpdateAndDelete(){

        testObject.delete(testRecipe);
        assertEquals(2,testObject.count());
        assertFalse(testObject.findById(3).isPresent());

        testObject.save(testRecipe);
        assertEquals(3,testObject.count());
        assertTrue(testObject.findById(4).isPresent());
    }

    @Test
    void testFindByRecipeNameContains(){
        String searchQuery = "b";
        List<Recipe> result = testObject.findByRecipeNameContains(searchQuery);

        assertEquals(2, result.size());
        assertTrue(result.contains(testRecipe));
    }


    @Test
    void testFindByRecipeIngredientName(){
        String searchQuery = "sallad";
        List<Recipe> result = testObject.findByRecipeIngredientsIngredientIngredientNameContains(searchQuery);

        assertEquals(2, result.size());
        assertTrue(result.contains(testRecipe));


        //Kan inte få denna att fungera?! Har testat allt, hjälp :(
    }

    @Test
    void testFindByRecipeCategoryName(){
        String searchQuery = "gott";
        List<Recipe> result = testObject.findByRecipeCategoriesCategoryContainsIgnoreCase(searchQuery);

        assertEquals(2, result.size());
        assertTrue(result.contains(testRecipe));

}
    @Test
    void testFindByRecipeCategoryMultipleName(){
        List<String> searchQuery = Arrays.asList("gott", "äckligt");
        List<Recipe> result = testObject.findRecipeByCategories(searchQuery);

        assertEquals(2, result.size());
        assertTrue(result.contains(testRecipe));

    }



}
