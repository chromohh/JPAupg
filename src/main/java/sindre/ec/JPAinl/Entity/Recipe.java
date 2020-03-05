package sindre.ec.JPAinl.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int recipeId;
    private String recipeName;

    @OneToMany(
            cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},
            fetch = FetchType.LAZY,
            mappedBy = "recipe",
            orphanRemoval=true
    )
    private List<RecipeIngredient> recipeIngredients = new ArrayList<>();;

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST}
    )
    @JoinTable(
            name = "recipe_recipe_categories",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "recipe_category_id")
    )
    private List<RecipeCategory> recipeCategories = new ArrayList<>();;

    @OneToOne(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST},
            orphanRemoval = true
    )
    @JoinColumn(name = "instruction_id")
    private RecipeInstruction recipeInstruction;

    public Recipe(String recipeName) {
        this.recipeName = recipeName;
    }

    Recipe(){}

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public void setRecipeIngredients(List<RecipeIngredient> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    public void setRecipeCategories(List<RecipeCategory> recipeCategories) {
        this.recipeCategories = recipeCategories;
    }

    public void setRecipeInstruction(RecipeInstruction recipeInstruction) {
        this.recipeInstruction = recipeInstruction;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public List<RecipeIngredient> getRecipeIngredients() {
        return recipeIngredients;
    }

    public List<RecipeCategory> getRecipeCategories() {
        return recipeCategories;
    }

    public RecipeInstruction getRecipeInstruction() {
        return recipeInstruction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return recipeId == recipe.recipeId &&
                Objects.equals(recipeName, recipe.recipeName) &&
                Objects.equals(recipeIngredients, recipe.recipeIngredients) &&
                Objects.equals(recipeCategories, recipe.recipeCategories) &&
                Objects.equals(recipeInstruction, recipe.recipeInstruction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipeId, recipeName, recipeIngredients, recipeCategories, recipeInstruction);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Recipe{");
        sb.append("recipeId=").append(recipeId);
        sb.append(", recipeName='").append(recipeName).append('\'');
        sb.append(", recipeIngredients=").append(recipeIngredients);
        sb.append(", recipeCategories=").append(recipeCategories);
        sb.append(", recipeInstruction=").append(recipeInstruction);
        sb.append('}');
        return sb.toString();
    }
}
