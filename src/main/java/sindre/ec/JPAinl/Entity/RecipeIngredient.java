package sindre.ec.JPAinl.Entity;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class RecipeIngredient {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "recipe_ingredient_id", unique = true)
    private String recipeIngredientID;
    private double amount;

    @Enumerated(EnumType.STRING)
    private Measurement measurement;

    @ManyToOne(
            cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

    @ManyToOne(
            cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    public RecipeIngredient(String recipeIngredientID, Ingredient ingredient, double amount, Measurement measurement) {
        this.recipeIngredientID = recipeIngredientID;
        this.ingredient = ingredient;
        this.amount = amount;
        this.measurement = measurement;
    }

    public RecipeIngredient(Ingredient ingredient, double amount, Measurement measurement) {
        this (null ,ingredient, amount, measurement);
    }

    RecipeIngredient(){}

    public String getRecipeIngredientID() {
        return recipeIngredientID;
    }

    public double getAmount() {
        return amount;
    }

    public Measurement getMeasurement() {
        return measurement;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setMeasurement(Measurement measurement) {
        this.measurement = measurement;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeIngredient that = (RecipeIngredient) o;
        return Double.compare(that.amount, amount) == 0 &&
                Objects.equals(recipeIngredientID, that.recipeIngredientID) &&
                measurement == that.measurement &&
                Objects.equals(ingredient, that.ingredient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipeIngredientID, amount, measurement, ingredient);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RecipeIngredient{");
        sb.append("recipeIngredientID='").append(recipeIngredientID).append('\'');
        sb.append(", amount=").append(amount);
        sb.append(", measurement=").append(measurement);
        sb.append(", ingredient=").append(ingredient);
        sb.append('}');
        return sb.toString();
    }
}
