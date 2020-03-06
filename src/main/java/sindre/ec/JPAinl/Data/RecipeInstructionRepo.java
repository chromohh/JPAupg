package sindre.ec.JPAinl.Data;

import org.springframework.data.repository.CrudRepository;
import sindre.ec.JPAinl.Entity.RecipeInstruction;

public interface RecipeInstructionRepo extends CrudRepository<RecipeInstruction, String> {
}
