package sindre.ec.JPAinl.Entity;

import javax.persistence.*;
import java.util.*;

@Entity
public class RecipeCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;
    private String category;

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST}
    )
    @JoinTable(
            name = "recipe_recipe_categories",
            joinColumns = @JoinColumn(name = "recipe_category_id"),
            inverseJoinColumns = @JoinColumn(name = "recipe_id")
    )
    private List<Recipe> recipes = new ArrayList<>();;


    public RecipeCategory(String category) {
        this.category = category;
    }

    RecipeCategory(){}

    public int getCategoryId() {
        return categoryId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeCategory that = (RecipeCategory) o;
        return categoryId == that.categoryId &&
                Objects.equals(category, that.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, category);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RecipeCategory{");
        sb.append("categoryId=").append(categoryId);
        sb.append(", category='").append(category).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
