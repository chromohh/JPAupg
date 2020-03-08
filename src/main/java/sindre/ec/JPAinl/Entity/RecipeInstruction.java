package sindre.ec.JPAinl.Entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class RecipeInstruction {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "instruction_id", unique = true)
    private String recipeInstructionId;

    @Column(length = 1500)
    private String recipeInstructions;

    public RecipeInstruction(String recipeInstructions) {
        this.recipeInstructions = recipeInstructions;
    }

    RecipeInstruction(){}

    public String getRecipeInstructionId() {
        return recipeInstructionId;
    }

    public String getRecipeInstructions() {
        return recipeInstructions;
    }

    public void setRecipeInstructions(String recipeInstructions) {
        this.recipeInstructions = recipeInstructions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeInstruction that = (RecipeInstruction) o;
        return Objects.equals(recipeInstructionId, that.recipeInstructionId) &&
                Objects.equals(recipeInstructions, that.recipeInstructions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipeInstructionId, recipeInstructions);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RecipeInstruction{");
        sb.append("recipeInstructionId='").append(recipeInstructionId).append('\'');
        sb.append(", recipeInstructions='").append(recipeInstructions).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
