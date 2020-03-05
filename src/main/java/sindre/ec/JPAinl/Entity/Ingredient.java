package sindre.ec.JPAinl.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ingredientId;
    @Column(unique = true)
    private String ingredientName;

    public Ingredient( String ingredientName) {
        this.ingredientName = ingredientName;
    }

    Ingredient(){}

    public int getIngredientId() {
        return ingredientId;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return ingredientId == that.ingredientId &&
                Objects.equals(ingredientName, that.ingredientName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ingredientId, ingredientName);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ingredient{");
        sb.append("ingredientId=").append(ingredientId);
        sb.append(", ingredientName='").append(ingredientName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
