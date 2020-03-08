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
            fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST},
            orphanRemoval = true,
            mappedBy = "recipe"
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

    public Recipe(String recipeName, List<RecipeIngredient> recipeIngredients, List<RecipeCategory> recipeCategories, RecipeInstruction recipeInstruction) {
        this.recipeName = recipeName;
        this.recipeIngredients = recipeIngredients;
        this.recipeCategories = recipeCategories;
        this.recipeInstruction = recipeInstruction;
    }

    public Recipe(int recipeId, String recipeName, RecipeInstruction recipeInstruction) {
        this.recipeId = recipeId;
        this.recipeName = recipeName;
        this.recipeInstruction = recipeInstruction;
    }

    public Recipe(String recipeName, RecipeInstruction recipeInstruction) {
        this(0,recipeName,recipeInstruction);
    }

    public Recipe(String recipeName) {
        this(0,recipeName,null);
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

    public boolean removeRecipeCategory(RecipeCategory recipeCategory){
        if (!recipeCategories.contains(recipeCategory)) return false;
        if (recipeCategory == null) return false;
        recipeCategory = null;
        return false;
    }

    public boolean addRecipeIngredient(RecipeIngredient recipeIngredient){
        if (recipeIngredient == null) return false;
        if (recipeIngredient.getRecipe() != null) return false;
        if (recipeIngredients.contains(recipeIngredient)) return false;
        recipeIngredient.setRecipe(this);
        return recipeIngredients.add(recipeIngredient);
    }

    public boolean removeRecipeIngredient(RecipeIngredient recipeIngredient){
        if (recipeIngredient == null) return false;
        if (recipeIngredient.getRecipe() != this) return false;
        recipeIngredient.setRecipe(null);
        return recipeIngredients.remove(recipeIngredient);
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
