package sindre.ec.JPAinl.RepoTestin;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import sindre.ec.JPAinl.Data.IngredientRepo;
import sindre.ec.JPAinl.Entity.Ingredient;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

@DataJpaTest
class IngridentRepositoryTest {

    @Autowired private IngredientRepo testObject;
    @Autowired private TestEntityManager em;

    private List<Ingredient> data ()  {
        return Arrays.asList(new Ingredient ("Paprika"),
                new Ingredient("Tomat"),
                new Ingredient("Gurka")
        );
    }

    @BeforeEach
    void setUp(){
        data().forEach(testObject::save);
    }

    @Test
    void injectionsNotNull(){
        assertNotNull(testObject);
        assertNotNull(em);
    }

}
